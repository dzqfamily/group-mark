package dzq.group.mark.mapper;

import dzq.group.mark.entity.GmSettle;

public interface GmSettleMapper {
    int insert(GmSettle record);

    GmSettle selectByPrimaryKey(Long id);

}