package dzq.group.mark.service;

import dzq.group.mark.entity.GmUser;
import dzq.group.mark.mapper.GmUserMapper;
import dzq.group.mark.utils.JJWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    public String getToken(GmUser gmUser) {
        return JJWTUtil.token(gmUser.getOpenid());
    }


    public GmUser getUserByToken(String token) {
        String openid = JJWTUtil.parseJWT(token);
        return gmUserMapper.getUserByOpenid(openid);
    }

}
