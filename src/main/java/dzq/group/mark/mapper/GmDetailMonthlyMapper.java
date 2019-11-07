package dzq.group.mark.mapper;

import dzq.group.mark.entity.GmDetailMonthly;
import org.apache.ibatis.annotations.Param;

public interface GmDetailMonthlyMapper {
    int insert(GmDetailMonthly record);

    GmDetailMonthly selectByPrimaryKey(Long id);

    GmDetailMonthly selectByMonthly(@Param("groupId") long groupId,@Param("monthly") String monthly);

    int addDetailNum(GmDetailMonthly detailMonthly);
}