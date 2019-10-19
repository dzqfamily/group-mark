package dzq.group.mark.mapper;

import dzq.group.mark.entity.GmUser;

public interface GmUserMapper {
    int insert(GmUser record);

    GmUser selectByPrimaryKey(Long id);

    GmUser getUserByOpenid(String openid);

    void updateAccessDate(GmUser gmUser);
}