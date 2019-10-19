package dzq.group.mark.controller;

import dzq.group.mark.vaild.RegisterUserValid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RegisterUserValid registerUserValid;


//    public static final Logger logger = Logger.getLogger(UserController.class);
//
//    @RequestMapping(value = "/login", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
//    @ResponseBody
//    public String login(@RequestParam String mobilePhone
//            , @RequestParam String password) {
//        logger.info("mobilePhone:" + mobilePhone + "login");
//
//        System.out.println("121");
//        return "{name:123}";
//    }
//
//    @RequestMapping(value = "/register", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
//    @ResponseBody
//    public String register(RegisterUser registerUser) {
//        logger.info(registerUser + "start regist");
//
//        GmUser gmUser = createGmUser(registerUser);
//
//        return userService.regist(gmUser);
//    }
//
//    private GmUser createGmUser(RegisterUser registerUser) {
//        GmUser gmUser = new GmUser();
////        gmUser.setUserId(IdGenerator.getId());
//        gmUser.setMobilePhone(registerUser.getMobilePhone());
//        gmUser.setNickName(registerUser.getNickName());
//        gmUser.setPassword(MD5Encrypt.encode(registerUser.getPassword()));
//        gmUser.setUserType("1");
//        return gmUser;
//    }
//
//    @RequestMapping(value = "/register", produces = "text/html;charset=UTF-8", method = RequestMethod.POST)
//    @ResponseBody
//    public String searchUser(@RequestParam String mobilePhone) {
//        return "";
//    }


}
