package dzq.group.mark.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lijianjianchi on 2016/11/20.
 */
@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    public static final Logger logger = Logger.getLogger(PurchaseController.class);

    @RequestMapping(value = "/create", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestParam String groupId, @RequestParam double amount, String remark) {
        logger.info("PurchaseController create:groupId=" + groupId + "amount=" + amount + "remark" + remark);


        System.out.println("121");
        return "{name:123}";
    }



}
