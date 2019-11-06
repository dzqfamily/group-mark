package dzq.group.mark.service;

import com.alibaba.fastjson.JSON;
import dzq.group.mark.common.DetailStatusCode;
import dzq.group.mark.common.ValidExCode;
import dzq.group.mark.domain.*;
import dzq.group.mark.entity.*;
import dzq.group.mark.exception.GroupMarkException;
import dzq.group.mark.mapper.GmDetailMapper;
import dzq.group.mark.mapper.GmDetailMoneyMapper;
import dzq.group.mark.mapper.GmGroupMapper;
import dzq.group.mark.mapper.GmGroupMemberMapper;
import dzq.group.mark.utils.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GmDetailService {
    @Autowired
    private GmUserService gmUserService;
    @Autowired
    private GmDetailMapper gmDetailMapper;
    @Autowired
    private GmDetailMoneyMapper gmDetailMoneyMapper;
    @Autowired
    private GmGroupMemberMapper gmGroupMemberMapper;

    @Transactional(rollbackFor = Exception.class)
    public void create(DetailRequest detailRequest) {

        GmUser gmUser = gmUserService.getUserByToken(detailRequest.getToken());

        checkDetailLimt(gmUser, detailRequest);

        GmDetail gmDetail = createDetail(detailRequest, gmUser);
        gmDetailMapper.insert(gmDetail);

        List<GmDetailMoney> gmDetailMoneyList = createDetailMoneyList(gmDetail, detailRequest);

        gmDetailMoneyMapper.insertBatch(gmDetailMoneyList);


    }

    private void checkDetailLimt(GmUser gmUser, DetailRequest detailRequest) {

        String yyyyMM = TimeUtil.format6(new Date());



    }

    private List<GmDetailMoney> createDetailMoneyList(GmDetail gmDetail, DetailRequest createDetailRequest) {
        List<GmDetailMoney> gmDetailMoneyList = new ArrayList<>();
        createDetailRequest.getMuchPeopleDetailMoneyList().forEach(muchPeopleDetail ->{
            GmDetailMoney gmDetailMoney = new GmDetailMoney();
            gmDetailMoney.setDetailId(gmDetail.getId());
            gmDetailMoney.setDirType("payer");
            gmDetailMoney.setGroupId(createDetailRequest.getGroupId());
            gmDetailMoney.setMemberId(muchPeopleDetail.getMemberId());
            gmDetailMoney.setMemberName(muchPeopleDetail.getMemberName());
            gmDetailMoney.setMoneyValue(muchPeopleDetail.getMoneyValue());
            gmDetailMoneyList.add(gmDetailMoney);
        });
        createDetailRequest.getPartDetailMoneyList().forEach(partDetail ->{
            GmDetailMoney gmDetailMoney = new GmDetailMoney();
            gmDetailMoney.setDetailId(gmDetail.getId());
            gmDetailMoney.setDirType("share");
            gmDetailMoney.setGroupId(createDetailRequest.getGroupId());
            gmDetailMoney.setMemberId(partDetail.getMemberId());
            gmDetailMoney.setMemberName(partDetail.getMemberName());
            gmDetailMoney.setMoneyValue(partDetail.getMoneyValue());
            gmDetailMoneyList.add(gmDetailMoney);
        });
        return gmDetailMoneyList;
    }

    private GmDetail createDetail(DetailRequest detailRequest,GmUser gmUser) {
        GmDetail gmDetail = new GmDetail();
        gmDetail.setGroupId(detailRequest.getGroupId());
        gmDetail.setMoneyValue(detailRequest.getMoneyValue());
        gmDetail.setMuchPeopleFlag(detailRequest.isMuchPeopleFlag() ? "Y" : "N");
        gmDetail.setOpenid(gmUser.getOpenid());
        gmDetail.setPartFlag(detailRequest.isPartFlag() ? "Y" : "N");
        gmDetail.setProject(detailRequest.getProject());
        gmDetail.setRemark(detailRequest.getRemark());
        gmDetail.setStatus("0");
        return gmDetail;
    }

    public BigDecimal unSetMoney(long groupId) {
        return gmDetailMapper.unSetMoney(groupId);
    }

    public List<GmDetail> selectDetailByGroupId(long groupId) {
        return gmDetailMapper.selectDetailByGroupId(groupId);
    }
    @Transactional(rollbackFor = Exception.class)
    public void update(DetailRequest detailRequest) {

        GmDetail gmDetail = gmDetailMapper.selectByPrimaryKey(detailRequest.getId());
        if (gmDetail == null || !DetailStatusCode.INIT.getCode().equals(gmDetail.getStatus())) {
            throw new GroupMarkException(ValidExCode.DETAIL_MODIFY_ERROR.getCode());
        }

        parseDetail(gmDetail, detailRequest);

        int count = gmDetailMapper.updateDetail(gmDetail);

        if (count == 0) {
            throw new GroupMarkException(ValidExCode.MODIFY_FREQUENT.getCode());
        }

        gmDetailMoneyMapper.deleteByDetailId(gmDetail.getId());

        List<GmDetailMoney> gmDetailMoneyList = createDetailMoneyList(gmDetail, detailRequest);
        gmDetailMoneyMapper.insertBatch(gmDetailMoneyList);

    }

    private void parseDetail(GmDetail gmDetail, DetailRequest detailRequest) {

        gmDetail.setRemark(detailRequest.getRemark());
        gmDetail.setProject(detailRequest.getProject());
        gmDetail.setPartFlag(detailRequest.isPartFlag() ? "Y" : "N");
        gmDetail.setMuchPeopleFlag(detailRequest.isMuchPeopleFlag() ? "Y" : "N");
        gmDetail.setMoneyValue(detailRequest.getMoneyValue());
    }

    public String selectDetailInfo(DetailInfoRequest detailInfoRequest) {

        GmDetail gmDetail = gmDetailMapper.selectByPrimaryKey(detailInfoRequest.getDetailId());
        if (gmDetail == null) {
            throw new GroupMarkException(ValidExCode.NOT_FOUND_DETAIL.getCode());
        }
        DetailInfoResponse detailInfoResponse = createDetailInfoResponse(gmDetail);

        return JSON.toJSONString(detailInfoResponse);
    }

    private DetailInfoResponse createDetailInfoResponse(GmDetail gmDetail) {

        List<GmDetailMoney> detailMoneyList = gmDetailMoneyMapper.detailMoneyByDetailId(gmDetail.getId());

        List<GmGroupMember> groupMemberList = gmGroupMemberMapper.selectMemberByGroupId(gmDetail.getGroupId());

        DetailInfoResponse detailInfoResponse = new DetailInfoResponse();
        detailInfoResponse.setId(gmDetail.getId());
        detailInfoResponse.setGroupId(gmDetail.getGroupId());
        detailInfoResponse.setMoneyValue(gmDetail.getMoneyValue().stripTrailingZeros().toPlainString());
        detailInfoResponse.setMuchPeopleFlag("Y".equals(gmDetail.getMuchPeopleFlag()));
        detailInfoResponse.setPartFlag("Y".equals(gmDetail.getPartFlag()));
        detailInfoResponse.setProject(gmDetail.getProject());
        detailInfoResponse.setRemark(gmDetail.getRemark());
        detailInfoResponse.setMemberMoneyList(getMemberMoneyList(groupMemberList, detailMoneyList));
        return detailInfoResponse;
    }

    private List<MemberMoneyResponse> getMemberMoneyList(List<GmGroupMember> groupMemberList, List<GmDetailMoney> detailMoneyList) {
        return groupMemberList.stream().map(gmGroupMember -> {
            MemberMoneyResponse memberMoneyResponse = new MemberMoneyResponse();
            memberMoneyResponse.setId(gmGroupMember.getId());
            memberMoneyResponse.setMemberName(gmGroupMember.getMemberName());
            parsePart(memberMoneyResponse,gmGroupMember, detailMoneyList);
            return memberMoneyResponse;
        }).collect(Collectors.toList());
    }

    private void parsePart(MemberMoneyResponse memberMoneyResponse,GmGroupMember gmGroupMember, List<GmDetailMoney> detailMoneyList) {
        for (GmDetailMoney gmDetailMoney : detailMoneyList) {
            if ("share".equals(gmDetailMoney.getDirType()) && gmDetailMoney.getMemberId() == gmGroupMember.getId()) {
                memberMoneyResponse.setPartChecked(true);
                memberMoneyResponse.setPartMoney(gmDetailMoney.getMoneyValue().stripTrailingZeros().toPlainString());
            }
            if ("payer".equals(gmDetailMoney.getDirType()) && gmDetailMoney.getMemberId() == gmGroupMember.getId()) {
                memberMoneyResponse.setMuchPeopleChecked(true);
                memberMoneyResponse.setMuchPeopleMoney(gmDetailMoney.getMoneyValue().stripTrailingZeros().toPlainString());
            }
        }
    }

    public void deleteDetail(DeleteDetailRequest deleteDetailRequest) {
        GmDetail gmDetail = gmDetailMapper.selectByPrimaryKey(deleteDetailRequest.getDetailId());

        if (gmDetail == null) {
            throw new GroupMarkException(ValidExCode.NOT_FOUND_DETAIL.getCode());
        }

        GmUser gmUser = gmUserService.getUserByToken(deleteDetailRequest.getToken());
        if (!gmUser.getOpenid().equals(gmDetail.getOpenid())) {
            throw new GroupMarkException(ValidExCode.DELETE_DETAIL_NOT_SELF.getCode());
        }

        gmDetailMapper.deleteDetail(deleteDetailRequest.getDetailId());
    }
}
