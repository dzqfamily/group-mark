package dzq.group.mark.mapper;

import dzq.group.mark.entity.GmSettle;

import java.util.List;

public interface GmSettleMapper {
    int insert(GmSettle record);

    GmSettle selectByPrimaryKey(Long id);

    List<GmSettle> selectSettleList(long groupId);
}