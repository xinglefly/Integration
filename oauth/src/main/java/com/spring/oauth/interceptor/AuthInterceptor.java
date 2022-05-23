package com.spring.oauth.interceptor;

import com.spring.oauth.domain.UserBean;
import com.spring.oauth.util.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xingle
 * @Description:拦截器的形式来实现权限管控。
 * @Date: 2022/5/23 4:29 下午
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        //1、不需要登录就可以访问的路径
        if (requestURI.contains(".") || requestURI.startsWith("/" + Constants.RESOURCE_COMMON + "/")) {
            return true;
        }

        //2、未登录用户，直接拒绝访问
        if (null == request.getSession().getAttribute(Constants.FLAG_CURRENT_USER)) {
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("please login first!");
            return false;
        } else {
            UserBean currentUser = (UserBean) request.getSession().getAttribute(Constants.FLAG_CURRENT_USER);
            //3、已登录用户，判断是否有资源访问权限
            if (requestURI.contains("/" + Constants.RESOURCE_MOBILE + "/") && currentUser.havePermission(Constants.RESOURCE_MOBILE)) {
                return true;
            } else if (requestURI.contains("/" + Constants.RESOURCE_SALARY + "/") && currentUser.havePermission(Constants.RESOURCE_SALARY)) {
                return true;
            } else {
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("no auth to visit!");
                return false;
            }
        }

    }
}
