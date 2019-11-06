package dzq.group.mark.controller;

import com.alibaba.fastjson.JSON;
import dzq.group.mark.domain.LoginUser;
import dzq.group.mark.entity.GmUser;
import dzq.group.mark.service.GmUserService;
import dzq.group.mark.utils.HttpClientUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    public static final Logger logger = Logger.getLogger(LoginController.class);
    @Value("${appid}")
    private String appid;
    @Value("${appSecret}")
    private String appSecret;
    @Value("${groupLimit}")
    private int groupLimit;
    @Value("${memberLimit}")
    private int memberLimit;
    @Value("${detailLimit}")
    private int detailLimit;
    @Autowired
    private GmUserService gmUserService;

    @RequestMapping(value = "/login", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String create(LoginUser loginUser) {
        logger.info("LoginController code:" + loginUser);
        Map<String, String> result = new HashMap<>();
        HttpClientUtil httpClientUtil = new HttpClientUtil();
        httpClientUtil.addParam("appid",appid)
                .addParam("secret",appSecret)
                .addParam("js_code",loginUser.getCode())
                .addParam("grant_type","authorization_code");
        String code2Session = null;
        try {
            code2Session = httpClientUtil.get("https://api.weixin.qq.com/sns/jscode2session");
        } catch (Exception e) {
            logger.info("LoginController jscode2session error");
        }
        if (!StringUtils.isEmpty(code2Session)) {
            Map<String, String> userInfo = JSON.parseObject(code2Session, Map.class);
            GmUser gmUser = gmUserService.getUserByOpenid(userInfo.get("openid"));
            if (gmUser == null) {
                gmUser = new GmUser();
                gmUser.setOpenid(userInfo.get("openid"));
                gmUser.setSessionKey(userInfo.get("session_key"));
                gmUser.setNickName(loginUser.getNickName());
                gmUser.setDetailLimit(detailLimit);
                gmUser.setGroupLimit(groupLimit);
                gmUser.setMemberLimit(memberLimit);
                gmUserService.login(gmUser);
            }
            result.put("code", "0000");
            result.put("token", gmUserService.getToken(gmUser));
        } else {
            result.put("code", "0001");
        }
        return JSON.toJSONString(result);
    }

}
