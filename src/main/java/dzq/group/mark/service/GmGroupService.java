package dzq.group.mark.service;

import dzq.group.mark.domain.*;
import dzq.group.mark.entity.*;
import dzq.group.mark.mapper.*;
import dzq.group.mark.utils.JJWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GmGroupService {
    @Autowired
    private GmUserService gmUserService;
    @Autowired
    private GmGroupMapper gmGroupMapper;
    @Autowired
    private GmGroupMemberMapper gmGroupMemberMapper;
    @Autowired
    private GmDetailMapper gmDetailMapper;
    @Autowired
    private GmDetailMoneyMapper gmDetailMoneyMapper;

    @Transactional(rollbackFor = Exception.class)
    public void createGroup(CreateGroupRequest createGroupRequest) {

        GmUser gmUser = gmUserService.getUserByToken(createGroupRequest.getToken());

        GmGroup gmGroup = new GmGroup();
        gmGroup.setGroupName(createGroupRequest.getGroupName());
        gmGroup.setOpenid(gmUser.getOpenid());

        gmGroupMapper.insert(gmGroup);
        //创建自己
        List<GmGroupMember> gmGroupMemberList = new ArrayList<>();
        GmGroupMember ggm = new GmGroupMember();
        ggm.setGroupId(gmGroup.getId());
        ggm.setMemberName(gmUser.getNickName());
        ggm.setOpenid(gmUser.getOpenid());
        gmGroupMemberList.add(ggm);
        //其他成员
        if (!StringUtils.isEmpty(createGroupRequest.getMemberList())) {
            Arrays.stream(createGroupRequest.getMemberList().split(",")).forEach(groupMember -> {
                GmGroupMember other = new GmGroupMember();
                other.setGroupId(gmGroup.getId());
                other.setMemberName(groupMember);
                gmGroupMemberList.add(other);
            });
        }
        //创建者

        gmGroupMemberMapper.insertBatch(gmGroupMemberList);

    }

    public List<GmGroup> selectMyGroup(BaseRequest baseRequest) {
        GmUser gmUser = gmUserService.getUserByToken(baseRequest.getToken());
        return gmGroupMapper.selectMyGroup(gmUser.getOpenid());
    }

    public GmGroupMember selectMyGroupMemberSelf(MyGroupMemberRequest myGroupMemberRequest) {
        GmUser gmUser = gmUserService.getUserByToken(myGroupMemberRequest.getToken());
        if (gmUser != null) {
            return gmGroupMemberMapper.selectMemberByGroupIdSelf(gmUser.getOpenid(), myGroupMemberRequest.getGroupId());
        }
        return null;
    }

    public List<GmGroupMemberView> selectMyGroupMember(MyGroupMemberRequest myGroupMemberRequest) {
        String openid = JJWTUtil.parseJWT(myGroupMemberRequest.getToken());
        List<GmGroupMember> gmGroupMemberList = gmGroupMemberMapper.selectMemberByGroupId(myGroupMemberRequest.getGroupId());
        List<GmGroupMemberView> gmGroupMemberViewList  = gmGroupMemberList.stream().map(gmGroupMember -> {
            GmGroupMemberView gmGroupMemberView = new GmGroupMemberView();
            gmGroupMemberView.setGroupId(gmGroupMember.getGroupId());
            gmGroupMemberView.setMemberName(gmGroupMember.getMemberName());
            gmGroupMemberView.setId(gmGroupMember.getId());
            if (openid.equals(gmGroupMember.getOpenid())) {
                gmGroupMemberView.setMuchPeopleChecked(true);
            }
            return gmGroupMemberView;
        }).collect(Collectors.toList());
        return gmGroupMemberViewList;
    }

    public void addGroupMember(AddGroupMemberRequest addGroupMemberRequest) {

        GmGroupMember gmGroupMember = new GmGroupMember();
        gmGroupMember.setMemberName(addGroupMemberRequest.getMemberAliasName());
        gmGroupMember.setGroupId(addGroupMemberRequest.getGroupId());

        gmGroupMemberMapper.insert(gmGroupMember);
    }

    public void modifyGroupName(ModifyGroupNameRequest modifyGroupNameRequest) {

        GmGroup gmGroup = new GmGroup();
        gmGroup.setId(modifyGroupNameRequest.getGroupId());
        gmGroup.setGroupName(modifyGroupNameRequest.getGroupName());

        gmGroupMapper.modifyGroupName(gmGroup);

    }

    public GmGroup selectGroupById(long groupId) {
        return gmGroupMapper.selectByPrimaryKey(groupId);
    }

    public void modifyGroupMemberName(ModifyGroupMemberNameRequest modifyGroupMemberNameRequest) {

        GmGroupMember gmGroupMember = new GmGroupMember();
        gmGroupMember.setId(modifyGroupMemberNameRequest.getGroupMemberId());
        gmGroupMember.setMemberName(modifyGroupMemberNameRequest.getGroupMemberName());

        gmGroupMemberMapper.modifyGroupMemberName(gmGroupMember);
    }

    public void deleteMember(DeleteMemberRequest deleteMemberRequest) {
        gmGroupMemberMapper.deleteMember(deleteMemberRequest.getGroupMemberId());
    }

    public void deleteGroup(DeleteGroupRequest deleteGroupRequest) {
        gmGroupMapper.deleteGroup(deleteGroupRequest.getGroupId());
    }

    public List<GmGroup> selectMyCrtGroup(BaseRequest baseRequest) {
        String openid = JJWTUtil.parseJWT(baseRequest.getToken());
        return gmGroupMapper.selectMyCrtGroup(openid);
    }

    public GmGroup selectGroupMyCreate(MyGroupMemberRequest myGroupMemberRequest) {
        String openid = JJWTUtil.parseJWT(myGroupMemberRequest.getToken());
        return gmGroupMapper.selectGroupMyCreate(myGroupMemberRequest.getGroupId(), openid);
    }

    public DoSetResponse doSet(DoSetRequest doSetRequest) {
        DoSetResponse doSetResponse = new DoSetResponse();
        List<GmDetail> unSetDetailList = gmDetailMapper.unSetDetailList(doSetRequest.getGroupId());
        int setNum = 0;
        String detailIdList = "";
        BigDecimal setMoney = new BigDecimal(0);
        Map<Long, MemberSetResponse> setResponseList = new HashMap<>();
        for (GmDetail gmDetail : unSetDetailList) {
            setNum++;
            setMoney = setMoney.add(gmDetail.getMoneyValue());
            detailIdList += gmDetail.getId();
            if (unSetDetailList.size() != setNum) {
                detailIdList += ",";
            }
            List<GmDetailMoney> detailMoneyList = gmDetailMoneyMapper.detailMoneyByDetailId(gmDetail.getId());
            accumulate(setResponseList, detailMoneyList);
        }
        doSetResponse.setDetailIdList(detailIdList);
        doSetResponse.setSetMoney(setMoney);
        doSetResponse.setSetNum(setNum);
        doSetResponse.setSetResponseList(setResponseList.values().stream()
                .filter(memberSetResponse -> memberSetResponse.getSetMoney().compareTo(new BigDecimal(0)) == 0)
                .map(memberSetResponse -> {
                    if (memberSetResponse.getSetMoney().compareTo(new BigDecimal(0)) > 0) {
                        memberSetResponse.setDirection("I");
                    } else {
                        memberSetResponse.setDirection("D");
                    }
                    return memberSetResponse;
                })
                .sorted(Comparator.comparing(MemberSetResponse::getSetMoney)).collect(Collectors.toList()));

        return doSetResponse;
    }

    private void accumulate(Map<Long, MemberSetResponse> setResponseList, List<GmDetailMoney> detailMoneyList) {

        for (GmDetailMoney gmDetailMoney : detailMoneyList) {
            MemberSetResponse memberSetResponse = setResponseList.get(gmDetailMoney.getMemberId());
            if (memberSetResponse == null) {
                memberSetResponse = new MemberSetResponse();
                memberSetResponse.setGroupMemberId(gmDetailMoney.getMemberId());
                memberSetResponse.setMemberName(gmDetailMoney.getMemberName());
                memberSetResponse.accumulate(gmDetailMoney.getDirType(), gmDetailMoney.getMoneyValue());
            }else{
                memberSetResponse.accumulate(gmDetailMoney.getDirType(), gmDetailMoney.getMoneyValue());
            }
        }

    }
}
