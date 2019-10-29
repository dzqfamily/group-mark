package dzq.group.mark.mapper;

import dzq.group.mark.entity.GmDetailMoney;

import java.util.List;

public interface GmDetailMoneyMapper {
    int insert(GmDetailMoney record);

    GmDetailMoney selectByPrimaryKey(Long id);

    void insertBatch(List<GmDetailMoney> gmDetailMoneyList);
}