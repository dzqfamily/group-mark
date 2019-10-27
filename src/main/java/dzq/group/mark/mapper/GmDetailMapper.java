package dzq.group.mark.mapper;

import dzq.group.mark.entity.GmDetail;

public interface GmDetailMapper {
    int insert(GmDetail record);

    GmDetail selectByPrimaryKey(Long id);

}