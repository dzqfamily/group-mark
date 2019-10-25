package dzq.group.mark.service;

import dzq.group.mark.domain.BaseRequest;
import dzq.group.mark.domain.CreateGroupRequest;
import dzq.group.mark.domain.GmGroupMemberView;
import dzq.group.mark.domain.MyGroupMemberRequest;
import dzq.group.mark.entity.GmGroup;
import dzq.group.mark.entity.GmGroupMember;
import dzq.group.mark.entity.GmUser;
import dzq.group.mark.mapper.GmGroupMapper;
import dzq.group.mark.mapper.GmGroupMemberMapper;
import dzq.group.mark.mapper.GmUserMapper;
import dzq.group.mark.utils.JJWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GmGroupService {
    @Autowired
    private GmUserService gmUserService;
    @Autowired
    private GmGroupMapper gmGroupMapper;
    @Autowired
    private GmGroupMemberMapper gmGroupMemberMapper;

    @Transactional(rollbackFor = Exception.class)
    public void createGroup(CreateGroupRequest createGroupRequest) {

        GmUser gmUser = gmUserService.getUserByToken(createGroupRequest.getToken());

        GmGroup gmGroup = new GmGroup();
        gmGroup.setGroupName(createGroupRequest.getGroupName());
        gmGroup.setOpenid(gmUser.getOpenid());

        gmGroupMapper.insert(gmGroup);
        List<GmGroupMember> gmGroupMemberList = new ArrayList<>();
        if (!StringUtils.isEmpty(createGroupRequest.getMemberList())) {
            Arrays.stream(createGroupRequest.getMemberList().split(",")).forEach(groupMember -> {
                GmGroupMember ggm = new GmGroupMember();
                ggm.setGroupId(gmGroup.getId());
                ggm.setMemberName(groupMember);
                gmGroupMemberList.add(ggm);
            });
        }
        //创建者
        GmGroupMember ggm = new GmGroupMember();
        ggm.setGroupId(gmGroup.getId());
        ggm.setMemberName(gmUser.getNickName());
        ggm.setOpenid(gmUser.getOpenid());
        gmGroupMemberList.add(ggm);
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
                gmGroupMemberView.setSelf(true);
            }
            return gmGroupMemberView;
        }).collect(Collectors.toList());
        return gmGroupMemberViewList;
    }
}
