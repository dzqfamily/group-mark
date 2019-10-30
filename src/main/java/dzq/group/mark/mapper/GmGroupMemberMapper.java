package dzq.group.mark.mapper;

import dzq.group.mark.entity.GmGroup;
import dzq.group.mark.entity.GmGroupMember;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GmGroupMemberMapper {
    int insert(GmGroupMember record);

    GmGroupMember selectByPrimaryKey(Long id);

    void insertBatch(List<GmGroupMember> gmGroupMemberList);

    GmGroupMember selectMemberByGroupIdSelf(@Param("openid") String openid,@Param("groupId") long groupId);

    List<GmGroupMember> selectMemberByGroupId(long groupId);

}