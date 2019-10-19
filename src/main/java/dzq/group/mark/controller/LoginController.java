package dzq.group.mark.controller;

import com.alibaba.fastjson.JSON;
import dzq.group.mark.domain.LoginUser;
import dzq.group.mark.entity.GmUser;
import dzq.group.mark.service.GmUserService;
import dzq.group.mark.utils.HttpClientUtil;
import dzq.group.mark.utils.MD5Encrypt;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.net.URISyntaxException;
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
            if (gmUser != null) {
                gmUserService.updateAccessDate(gmUser);
            } else {
                gmUser = new GmUser();
                gmUser.setOpenid(userInfo.get("openid"));
                gmUser.setSessionKey(userInfo.get("session_key"));
                gmUser.setNickName(loginUser.getNickName());
                gmUser.md5();
                gmUserService.login(gmUser);
            }
            result.put("code", "0000");
            result.put("token", gmUser.getToken());
        } else {
            result.put("code", "0001");
        }
        return JSON.toJSONString(result);
    }

    /**
     * 查找团员
     * @param groupId 团ID
     * @return 返回团员列表json
     */
    @RequestMapping(value = "/users", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String users(@RequestParam String groupId) {
        return "";
    }

    /**
     * 团里增加成员
     * @param groupId 被关联团ID
     * @param userId 要关联的用户ID
     * @return
     */
    @RequestMapping(value = "/related", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String related(@RequestParam String groupId, @RequestParam String userId) {
        return "";
    }

    /**
     * 团里增加成员
     * @param groupId 被关联团ID
     * @param userId 要关联的用户ID
     * @return
     */
    @RequestMapping(value = "/groupListByUser", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String groupListByUser(@RequestParam String groupId, @RequestParam String userId) {
        return "";
    }


}
