package dzq.group.mark.controller;

import com.alibaba.fastjson.JSON;
import dzq.group.mark.common.DetailStatusCode;
import dzq.group.mark.common.ValidExCode;
import dzq.group.mark.domain.*;
import dzq.group.mark.entity.GmDetail;
import dzq.group.mark.exception.GroupMarkException;
import dzq.group.mark.exception.ValidException;
import dzq.group.mark.service.GmDetailService;
import dzq.group.mark.service.GmGroupService;
import dzq.group.mark.service.GmUserService;
import dzq.group.mark.vaild.CreateDetailValid;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/detail")
public class DetailController {

    public static final Logger logger = Logger.getLogger(DetailController.class);
    @Autowired
    private CreateDetailValid createDetailValid;
    @Autowired
    private GmDetailService gmDetailService;
    @Autowired
    private GmUserService gmUserService;
    @Autowired
    private GmGroupService gmGroupService;


    @RequestMapping(value = "/create", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String create(DetailRequest detailRequest) {

        logger.info(detailRequest);

        Map<String, String> result = new HashMap<>();
        try {

            createDetailValid.vaild(detailRequest);

            //是否是本团团员
            gmGroupService.checkSelfGroup(detailRequest.getGroupId(), detailRequest.getToken());

            if (detailRequest.getId() > 0) {
                gmDetailService.update(detailRequest);
            }else{
                gmDetailService.create(detailRequest);
            }

        } catch (ValidException e) {
            result.put("code", e.getCode());
            result.put("msg", e.getMsg());
            return JSON.toJSONString(result);
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

    @RequestMapping(value = "/detailList", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String detailList(DetailListRequest detailListRequest) {

        logger.info(detailListRequest);

        Map<String, Object> result = new HashMap<>();
        try {

            //是否是本团团员
            gmGroupService.checkSelfGroup(detailListRequest.getGroupId(), detailListRequest.getToken());

            List<GmDetail> gmDetailList = gmDetailService.selectDetailByGroupId(detailListRequest.getGroupId());

            List<GmDetailView> gmDetailViewList = gmDetailList.stream().map(gmDetail -> {
                GmDetailView gmDetailView = new GmDetailView();
                BeanUtils.copyProperties(gmDetail, gmDetailView);
                gmDetailView.setMoneyValueStr(gmDetail.getMoneyValue().stripTrailingZeros().toPlainString());
                gmDetailView.setCreateNickName(getNickName(gmDetail.getOpenid()));
                gmDetailView.setStatusName(DetailStatusCode.getMsgByCode(gmDetail.getStatus()));
                gmDetailView.setCreatedDateStr(new SimpleDateFormat("MM-dd HH:mm:ss").format(gmDetail.getCreatedDate()));
                return gmDetailView;
            }).collect(Collectors.toList());

            result.put("gmDetailViewList", gmDetailViewList);

        } catch (GroupMarkException e) {
            result.put("code", e.getCode());
            result.put("msg", e.getMsg());
            return JSON.toJSONString(result);
        } catch (Exception e) {
            logger.info("GroupController create" + e);
            result.put("code", ValidExCode.ERROR.getCode());
            result.put("msg", ValidExCode.ERROR.getMsg());
            return JSON.toJSONString(result);
        }
        result.put("code", ValidExCode.SUCCESS.getCode());
        result.put("msg", ValidExCode.SUCCESS.getMsg());
        return JSON.toJSONString(result);

    }

    @RequestMapping(value = "/detailInfo", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String detailInfo(DetailInfoRequest detailInfoRequest) {

        logger.info(detailInfoRequest);

        Map<String, Object> result = new HashMap<>();
        try {
            //是否是本团团员
            gmGroupService.checkSelfGroup(detailInfoRequest.getGroupId(), detailInfoRequest.getToken());

            String detailInfo = gmDetailService.selectDetailInfo(detailInfoRequest);
            result.put("detailInfo", detailInfo);
        } catch (GroupMarkException e) {
            result.put("code", e.getCode());
            result.put("msg", e.getMsg());
            return JSON.toJSONString(result);
        } catch (Exception e) {
            logger.info("GroupController create" + e);
            result.put("code", ValidExCode.ERROR.getCode());
            result.put("msg", ValidExCode.ERROR.getMsg());
            return JSON.toJSONString(result);
        }
        result.put("code", ValidExCode.SUCCESS.getCode());
        result.put("msg", ValidExCode.SUCCESS.getMsg());
        return JSON.toJSONString(result);

    }


    @RequestMapping(value = "/deleteDetail", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String deleteDetail(DeleteDetailRequest deleteDetailRequest) {

        logger.info(deleteDetailRequest);

        Map<String, Object> result = new HashMap<>();
        try {

            gmDetailService.deleteDetail(deleteDetailRequest);
        } catch (Exception e) {
            logger.info("GroupController create" + e);
            result.put("code", ValidExCode.ERROR.getCode());
            result.put("msg", ValidExCode.ERROR.getMsg());
            return JSON.toJSONString(result);
        }
        result.put("code", ValidExCode.SUCCESS.getCode());
        result.put("msg", ValidExCode.SUCCESS.getMsg());
        return JSON.toJSONString(result);

    }

    private String getNickName(String openid) {
        return gmUserService.getUserByOpenid(openid).getNickName();
    }

}
