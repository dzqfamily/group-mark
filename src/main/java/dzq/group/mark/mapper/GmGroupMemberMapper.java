package dzq.group.mark.mapper;

import dzq.group.mark.entity.GmGroup;
import dzq.group.mark.entity.GmGroupMember;

import java.util.List;

public interface GmGroupMemberMapper {
    int insert(GmGroupMember record);

    GmGroupMember selectByPrimaryKey(Long id);

}