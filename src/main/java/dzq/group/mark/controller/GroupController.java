package dzq.group.mark.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/group")
public class GroupController {

    public static final Logger logger = Logger.getLogger(GroupController.class);

    @RequestMapping(value = "/create", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestParam String nickName) {
        logger.info("GroupController create:" + nickName);

        System.out.println("121");
        return "{name:123}";
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


}
