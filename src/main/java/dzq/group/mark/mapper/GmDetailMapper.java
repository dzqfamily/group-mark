package dzq.group.mark.mapper;

import dzq.group.mark.domain.GmDetailView;
import dzq.group.mark.entity.GmDetail;

import java.math.BigDecimal;
import java.util.List;

public interface GmDetailMapper {
    int insert(GmDetail record);

    GmDetail selectByPrimaryKey(Long id);

    BigDecimal unSetMoney(long groupId);

    List<GmDetail> selectDetailByGroupId(long groupId);

    int updateDetail(GmDetail gmDetail);

    void deleteDetail(long id);

    List<GmDetail> unSetDetailList(long groupId);

    int setDetail(List<Long> detailIdArray);

    List<GmDetail> selectByIdList(List<Long> detailIdList);
}