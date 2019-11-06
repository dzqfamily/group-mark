package dzq.group.mark.controller;

import com.alibaba.fastjson.JSON;
import dzq.group.mark.common.ValidExCode;
import dzq.group.mark.domain.*;
import dzq.group.mark.entity.GmGroup;
import dzq.group.mark.entity.GmGroupMember;
import dzq.group.mark.exception.GroupMarkException;
import dzq.group.mark.exception.ValidException;
import dzq.group.mark.service.GmDetailService;
import dzq.group.mark.service.GmGroupService;
import dzq.group.mark.vaild.CreateGroupValid;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/group")
public class GroupController {

    public static final Logger logger = Logger.getLogger(GroupController.class);
    @Autowired
    private CreateGroupValid createGroupValid;
    @Autowired
    private GmGroupService gmGroupService;
    @Autowired
    private GmDetailService gmDetailService;


    @RequestMapping(value = "/create", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String create(CreateGroupRequest createGroupRequest) {

        logger.info(createGroupRequest);

        Map<String, String> result = new HashMap<>();
        try {

            createGroupValid.vaild(createGroupRequest);
            gmGroupService.createGroup(createGroupRequest);

            logger.info(createGroupRequest + "GroupController create success");
        } catch (ValidException e) {
            result.put("code", e.getCode());
            result.put("msg", e.getMsg());
            return JSON.toJSONString(result);
        } catch(GroupMarkException e){
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

    @RequestMapping(value = "/myGroupView", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String myGroupView(BaseRequest baseRequest) {

        logger.info(baseRequest);

        Map<String, Object> result = new HashMap<>();

        try {

            List<GmGroup> groupList = gmGroupService.selectMyGroup(baseRequest);
            List<GmGroupView> groupViewList = new ArrayList<>();
            groupList.forEach(gmGroup -> {
                GmGroupView gmGroupView = new GmGroupView();
                BeanUtils.copyProperties(gmGroup, gmGroupView);
                gmGroupView.setUnSetMoney(gmDetailService.unSetMoney(gmGroup.getId()).stripTrailingZeros().toPlainString());
                groupViewList.add(gmGroupView);
            });
            result.put("myGroupViewList", groupViewList);
            logger.info("GroupController myGroup size = " + groupList.size());

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

    @RequestMapping(value = "/myGroupMember", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String myGroupMember(MyGroupMemberRequest myGroupMemberRequest) {

        logger.info(myGroupMemberRequest);

        Map<String, Object> result = new HashMap<>();

        try {

            GmGroupMember gmGroupMemberSelf = gmGroupService.selectMyGroupMemberSelf(myGroupMemberRequest);
            GmGroup gmGroup = gmGroupService.selectGroupMyCreate(myGroupMemberRequest);
            if (gmGroupMemberSelf == null && gmGroup == null) {
                result.put("code", ValidExCode.PARAM_ERROR.getCode());
                result.put("msg",  ValidExCode.PARAM_ERROR.getMsg());
                return JSON.toJSONString(result);
            }
            List<GmGroupMemberView> groupMemberList = gmGroupService.selectMyGroupMember(myGroupMemberRequest);

            result.put("groupMemberList", groupMemberList);
            logger.info("GroupController myGroupMember size = " + groupMemberList.size());

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

    @RequestMapping(value = "/addGroupMember", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String addGroupMember(AddGroupMemberRequest addGroupMemberRequest) {

        logger.info(addGroupMemberRequest);

        Map<String, Object> result = new HashMap<>();

        try {

            gmGroupService.addGroupMember(addGroupMemberRequest);

        } catch (GroupMarkException e) {
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

    @RequestMapping(value = "/modifyGroupName", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String modifyGroupName(ModifyGroupNameRequest modifyGroupNameRequest) {

        logger.info(modifyGroupNameRequest);

        Map<String, Object> result = new HashMap<>();

        try {

            gmGroupService.modifyGroupName(modifyGroupNameRequest);

        } catch (GroupMarkException e) {
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

    @RequestMapping(value = "/groupInfo", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String groupInfo(GroupInfoRequest groupInfoRequest) {

        logger.info(groupInfoRequest);

        Map<String, Object> result = new HashMap<>();

        try {

            GmGroup gmGroup = gmGroupService.selectGroupById(groupInfoRequest.getGroupId());
            result.put("gmGroup", gmGroup);
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

    @RequestMapping(value = "/modifyGroupMemberName", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String modifyGroupMemberName(ModifyGroupMemberNameRequest modifyGroupMemberNameRequest) {

        logger.info(modifyGroupMemberNameRequest);
        Map<String, Object> result = new HashMap<>();
        try {
            gmGroupService.modifyGroupMemberName(modifyGroupMemberNameRequest);
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

    @RequestMapping(value = "/deleteMember", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String deleteMember(DeleteMemberRequest deleteMemberRequest) {

        logger.info(deleteMemberRequest);
        Map<String, Object> result = new HashMap<>();
        try {
            gmGroupService.deleteMember(deleteMemberRequest);
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

    @RequestMapping(value = "/deleteGroup", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String deleteGroup(DeleteGroupRequest deleteGroupRequest) {

        logger.info(deleteGroupRequest);
        Map<String, Object> result = new HashMap<>();
        try {
            gmGroupService.deleteGroup(deleteGroupRequest);
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

    @RequestMapping(value = "/doSet", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String doSet(DoSetRequest doSetRequest) {

        logger.info(doSetRequest);
        Map<String, Object> result = new HashMap<>();
        try {
            DoSetResponse doSetResponse = gmGroupService.doSet(doSetRequest);
            result.put("doSetResponse", doSetResponse);
        } catch (GroupMarkException e) {
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

    @RequestMapping(value = "/setDetail", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String setDetail(SetDetailRequest setDetailRequest) {

        logger.info(setDetailRequest);
        Map<String, Object> result = new HashMap<>();
        try {
            gmGroupService.setDetail(setDetailRequest);
        } catch (GroupMarkException e) {
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

    @RequestMapping(value = "/settleList", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String settleList(GroupInfoRequest groupInfoRequest) {

        logger.info(groupInfoRequest);
        Map<String, Object> result = new HashMap<>();
        try {
            List<SettleResponse> settleList = gmGroupService.settleList(groupInfoRequest);
            result.put("settleList", settleList);
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

    @RequestMapping(value = "/settleInfo", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String settleInfo(SettleInfoRequest settleInfoRequest) {

        logger.info(settleInfoRequest);
        Map<String, Object> result = new HashMap<>();
        try {
            SettleResponse settleResponse = gmGroupService.settleInfo(settleInfoRequest);
            result.put("settleResponse", settleResponse);
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
