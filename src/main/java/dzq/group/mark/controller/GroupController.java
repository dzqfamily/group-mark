package dzq.group.mark.controller;

import com.alibaba.fastjson.JSON;
import dzq.group.mark.domain.CreateGroupRequest;
import dzq.group.mark.entity.GmUser;
import dzq.group.mark.exception.ValidException;
import dzq.group.mark.service.GmUserService;
import dzq.group.mark.vaild.CreateGroupValid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/group")
public class GroupController {

    public static final Logger logger = Logger.getLogger(GroupController.class);
    @Autowired
    private CreateGroupValid createGroupValid;
    @Autowired
    private GmUserService gmUserService;

    @RequestMapping(value = "/create", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String create(CreateGroupRequest createGroupRequest) {

        logger.info(createGroupRequest);

        Map<String, String> result = new HashMap<>();
        try {
            createGroupValid.vaild(createGroupRequest);
            GmUser gmUser = gmUserService.getUserByToken(createGroupRequest.getToken());


        } catch (ValidException e) {
            result.put("code", e.getCode());
            result.put("msg", e.getMsg());
            return JSON.toJSONString(result);
        }


        System.out.println("121");
        return "{name:123}";
    }
//
//    /**
//     * 查找团员
//     * @param groupId 团ID
//     * @return 返回团员列表json
//     */
//    @RequestMapping(value = "/users", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
//    @ResponseBody
//    public String users(@RequestParam String groupId) {
//        return "";
//    }
//
//    /**
//     * 团里增加成员
//     * @param groupId 被关联团ID
//     * @param userId 要关联的用户ID
//     * @return
//     */
//    @RequestMapping(value = "/related", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
//    @ResponseBody
//    public String related(@RequestParam String groupId, @RequestParam String userId) {
//        return "";
//    }
//
//    /**
//     * 团里增加成员
//     * @param groupId 被关联团ID
//     * @param userId 要关联的用户ID
//     * @return
//     */
//    @RequestMapping(value = "/groupListByUser", produces = "text/html;charset=UTF-8", method = RequestMethod.GET)
//    @ResponseBody
//    public String groupListByUser(@RequestParam String groupId, @RequestParam String userId) {
//        return "";
//    }


}
