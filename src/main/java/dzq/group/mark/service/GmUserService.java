package dzq.group.mark.service;

import dzq.group.mark.entity.GmUser;
import dzq.group.mark.mapper.GmUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GmUserService {
    @Autowired
    private GmUserMapper gmUserMapper;
    public void login(GmUser gmUser) {
        gmUserMapper.insert(gmUser);
    }

    public GmUser getUserByOpenid(String openid) {
        return gmUserMapper.getUserByOpenid(openid);
    }

    public void updateAccessDate(GmUser gmUser) {
        gmUserMapper.updateAccessDate(gmUser);
    }
}
