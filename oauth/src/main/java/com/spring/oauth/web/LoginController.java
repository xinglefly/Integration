package com.spring.oauth.web;

import com.spring.oauth.domain.UserBean;
import com.spring.oauth.service.AuthService;
import com.spring.oauth.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/23 2:34 下午
 */
@Slf4j
@RestController
@RequestMapping("/common")
public class LoginController {

    @Autowired
    private AuthService authService;

    private List<String> users = new ArrayList<>();

    @PostMapping("/test")
    public String testValid(@Valid @RequestBody UserBean user){
        String userName = user.getUserName();
        return "success";
    }


    @PostMapping("/login")
//    public UserBean login(UserBean user, HttpServletRequest request) {
    public UserBean login(@Valid @RequestParam String userName,@Valid @RequestParam String userPass, HttpServletRequest request) {
        UserBean user = new UserBean(userName, userPass);
        UserBean userBean = authService.query(user);
        if (null != userBean) {
            log.info(userBean.getUserName() + " login success!");
            request.getSession().setAttribute(Constants.FLAG_CURRENT_USER, userBean);
        }
        log.info("login failed!");
        return userBean;
    }

    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(HttpSession session) {
        return session.getAttribute(Constants.FLAG_CURRENT_USER);
    }

    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute(Constants.FLAG_CURRENT_USER);
    }


}
