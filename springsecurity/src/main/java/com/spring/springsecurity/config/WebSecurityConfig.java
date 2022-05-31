package com.spring.springsecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author: xingle
 * @Description: 注入一个自定义的配置
 * @Date: 2022/5/24 3:23 下午
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 配置安全拦截策略
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //链式配置拦截策略
        http.csrf().disable() //关闭csrg跨域检查
                .authorizeRequests()
                .antMatchers("/swagger-ui/**").permitAll()
                .antMatchers("/mobile/**").hasAuthority("mobile") //资源配置
                .antMatchers("/salary/**").hasAuthority("salary")
                .antMatchers("/common/**").permitAll()
                .and()
                .formLogin().defaultSuccessUrl("/main.html").failureForwardUrl("/common/loginFailed");// 可以从默认login页面登录，并且登录后跳转main.html
    }
}
