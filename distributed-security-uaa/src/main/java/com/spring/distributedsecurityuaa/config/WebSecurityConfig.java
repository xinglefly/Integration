package com.spring.distributedsecurityuaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @Author: xingle
 * @Description: 注入一个自定义的配置
 * @Date: 2022/5/24 3:23 下午
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private TokenStore tokenStore; //会通过之前的ClientDetailsServiceConfigurer注入到Spring容器中

    @Autowired
    private ClientDetailsService clientDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //从父类加载认证管理器
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new
                InMemoryUserDetailsManager(User.withUsername("admin").password(passwordEncoder().encode("admin")).authorities("mobile", "salary").build()
                , User.withUsername("manager").password(passwordEncoder().encode("manager")).authorities("salary").build()
                , User.withUsername("worker").password(passwordEncoder().encode("worker")).authorities("worker").build());
        return userDetailsManager;
    }

    /**
     * 配置安全拦截策略
     *
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //链式配置拦截策略
        http.csrf().disable() //关闭csrg跨域检查
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }
}
