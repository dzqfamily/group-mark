package dzq.group.mark.service;

import dzq.group.mark.domain.CreateDetailRequest;
import dzq.group.mark.domain.GmDetailView;
import dzq.group.mark.entity.GmDetail;
import dzq.group.mark.entity.GmDetailMoney;
import dzq.group.mark.mapper.GmDetailMapper;
import dzq.group.mark.mapper.GmDetailMoneyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class GmDetailService {
    @Autowired
    private GmUserService gmUserService;
    @Autowired
    private GmDetailMapper gmDetailMapper;
    @Autowired
    private GmDetailMoneyMapper gmDetailMoneyMapper;

    @Transactional(rollbackFor = Exception.class)
    public void create(CreateDetailRequest createDetailRequest) {

        GmDetail gmDetail = createDetail(createDetailRequest);
        gmDetailMapper.insert(gmDetail);

        List<GmDetailMoney> gmDetailMoneyList = createDetailMoneyList(gmDetail, createDetailRequest);

        gmDetailMoneyMapper.insertBatch(gmDetailMoneyList);


    }

    private List<GmDetailMoney> createDetailMoneyList(GmDetail gmDetail, CreateDetailRequest createDetailRequest) {
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

    private GmDetail createDetail(CreateDetailRequest createDetailRequest) {
        GmDetail gmDetail = new GmDetail();
        gmDetail.setGroupId(createDetailRequest.getGroupId());
        gmDetail.setMoneyValue(createDetailRequest.getMoneyValue());
        gmDetail.setMuchPeopleFlag(createDetailRequest.isMuchPeopleFlag() ? "Y" : "N");
        gmDetail.setOpenid(gmUserService.getUserByToken(createDetailRequest.getToken()).getOpenid());
        gmDetail.setPartFlag(createDetailRequest.isPartFlag() ? "Y" : "N");
        gmDetail.setProject(createDetailRequest.getProject());
        gmDetail.setRemark(createDetailRequest.getRemark());
        gmDetail.setStatus("0");
        return gmDetail;
    }

    public BigDecimal unSetMoney(long groupId) {
        return gmDetailMapper.unSetMoney(groupId);
    }

    public List<GmDetail> selectDetailByGroupId(long groupId) {
        return gmDetailMapper.selectDetailByGroupId(groupId);
    }
}
