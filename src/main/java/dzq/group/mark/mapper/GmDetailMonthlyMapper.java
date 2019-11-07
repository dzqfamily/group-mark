package dzq.group.mark.mapper;

import dzq.group.mark.entity.GmDetailMonthly;

public interface GmDetailMonthlyMapper {
    int insert(GmDetailMonthly record);

    GmDetailMonthly selectByPrimaryKey(Long id);
}