package dzq.group.mark.controller;

import com.alibaba.fastjson.JSON;
import dzq.group.mark.common.ValidExCode;
import dzq.group.mark.domain.*;
import dzq.group.mark.entity.GmGroup;
import dzq.group.mark.entity.GmGroupMember;
import dzq.group.mark.exception.ValidException;
import dzq.group.mark.service.GmGroupService;
import dzq.group.mark.vaild.CreateDetailValid;
import dzq.group.mark.vaild.CreateGroupValid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/detail")
public class DetailController {

    public static final Logger logger = Logger.getLogger(DetailController.class);
    @Autowired
    private CreateDetailValid createDetailValid;
    @Autowired
    private GmGroupService gmGroupService;


    @RequestMapping(value = "/create", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String create(CreateDetailRequest createDetailRequest) {

        logger.info(createDetailRequest);

        Map<String, String> result = new HashMap<>();
        try {

            createDetailValid.vaild(createDetailRequest);
//            gmGroupService.createGroup(createGroupRequest);

//            logger.info(createGroupRequest + "GroupController create success");
        } catch (ValidException e) {
            result.put("code", e.getCode());
            result.put("msg", e.getMsg());
            return JSON.toJSONString(result);
        } catch (Exception e) {
            logger.info("GroupController create" + e);
            result.put("code", ValidExCode.ERROR.getCode());
            result.put("msg",  ValidExCode.ERROR.getMsg());
            return JSON.toJSONString(result);
        }
        result.put("code", ValidExCode.SUCCESS.getCode());
        result.put("msg",  ValidExCode.SUCCESS.getMsg());
        return JSON.toJSONString(result);

    }
}
