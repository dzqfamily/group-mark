package dzq.group.mark.mapper;

import dzq.group.mark.entity.GmGroup;

import java.util.List;

public interface GmGroupMapper {
    int insert(GmGroup record);

    GmGroup selectByPrimaryKey(Long id);

    List<GmGroup> selectMyGroup(String openid);
}