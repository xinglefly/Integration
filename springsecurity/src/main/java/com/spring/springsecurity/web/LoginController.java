package com.spring.springsecurity.web;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/24 3:35 下午
 */
@Api(tags = "登录")
@Slf4j
@RestController
@RequestMapping("/common")
public class LoginController {

    @GetMapping("/getLoginUserByPrincipal")
    public String getLoginUserByPrincipal(Principal principal){
        return principal.getName();
    }

    @Operation(summary = "当前用户")
    @GetMapping("/currentUserName")
    public String currentUserName(Authentication authentication){
        return authentication.getName();
    }

    @Operation(summary = "用户")
    @GetMapping("/userName")
    public String currentUserNameSimple(HttpServletRequest request){
        Principal userPrincipal = request.getUserPrincipal();
        return userPrincipal.getName();
    }

    @Operation(summary = "登录用户")
    @GetMapping("/getLoginUser")
    public String getLoginUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername();
    }

}
