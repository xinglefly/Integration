package com.spring.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/24 3:06 下午
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * 默认Url根路径跳转到/login，此url为spring security提供
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/login");
    }


    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder(10);
//        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * 自行注入一个UserDetailsService
     * 如果没有的话，在UserDetailsServiceAutoConfiguration中会默认注入一个包含
     * user用户的InMemoryUserDetailsManager
     * 另外也可以采用修改configure(AuthenticationManagerBuilder auth)方法并注入authenticationManagerBean的方式。
     * @return
     */
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager(
                User.withUsername("admin").password(getPasswordEncoder().encode("admin")).authorities("mobile", "salary").build(),
                User.withUsername("manager").password(getPasswordEncoder().encode("manager")).authorities("mobile").build(),
                User.withUsername("worker").password("worker").authorities("worker").build());
        return userDetailsManager;
//        return new JdbcUserDetailsManager(DataSource source);
    }


}
