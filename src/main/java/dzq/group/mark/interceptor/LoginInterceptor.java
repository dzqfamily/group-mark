package dzq.group.mark.interceptor;

import dzq.group.mark.controller.GroupController;
import dzq.group.mark.utils.JJWTUtil;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    public static final Logger logger = Logger.getLogger(LoginInterceptor.class);
    private static String LOGIN_URI = "/groupmark/login/login";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (LOGIN_URI.equals(request.getRequestURI())) {
            return true;
        }

        String token = request.getParameter("token");
        try {
            JJWTUtil.parseJWT(token);
        } catch (Exception e) {
            response.getWriter().write("{\"code\":\"0002\"}");
            return false;
        }

        return super.preHandle(request, response, handler);
    }
}
