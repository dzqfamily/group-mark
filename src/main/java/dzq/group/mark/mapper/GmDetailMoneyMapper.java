package dzq.group.mark.mapper;

import dzq.group.mark.entity.GmDetailMoney;

public interface GmDetailMoneyMapper {
    int insert(GmDetailMoney record);

    GmDetailMoney selectByPrimaryKey(Long id);

}