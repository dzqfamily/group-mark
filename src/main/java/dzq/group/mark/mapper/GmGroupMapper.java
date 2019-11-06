package dzq.group.mark.mapper;

import dzq.group.mark.domain.DeleteGroupRequest;
import dzq.group.mark.domain.GmGroupView;
import dzq.group.mark.entity.GmGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GmGroupMapper {
    int insert(GmGroup record);

    GmGroup selectByPrimaryKey(Long id);

    List<GmGroup> selectMyGroup(String openid);

    int modifyGroupName(GmGroup gmGroup);

    void deleteGroup(Long id);

    List<GmGroup> selectMyCrtGroup(String openid);

    GmGroup selectGroupMyCreate(@Param("id") long id,@Param("openid") String openid);

    int addMemberNum(@Param("memberNum") int memberNum,@Param("gmGroup") GmGroup gmGroup);
}