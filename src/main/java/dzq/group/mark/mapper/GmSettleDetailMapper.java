package dzq.group.mark.mapper;

import dzq.group.mark.entity.GmSettleDetail;

import java.util.List;

public interface GmSettleDetailMapper {
    int insert(GmSettleDetail record);

    GmSettleDetail selectByPrimaryKey(Long id);

    void insertBatch(List<GmSettleDetail> gmSettleDetailList);

}