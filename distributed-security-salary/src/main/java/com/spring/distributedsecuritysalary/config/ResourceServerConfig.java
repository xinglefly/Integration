package com.spring.distributedsecuritysalary.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/25 10:56 下午
 */
@Configuration
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_SALARY = "salary";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_SALARY) //资源ID
                .tokenServices(tokenServices()) //使用远程服务验证令牌的服务
                .stateless(true); //无状态模式
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() //校验请求
                .antMatchers("/salary/**") // 路径匹配规则。
                .access("#oauth2.hasScope('all')") // 需要匹配scope
                .and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    //配置access_token远程验证策略。
    public ResourceServerTokenServices tokenServices() {
        RemoteTokenServices services = new RemoteTokenServices();
        services.setCheckTokenEndpointUrl("http://localhost:8003/uaa/oauth/check_token");
        services.setClientId("c1");
        services.setClientSecret("secret");
        return services;
    }
}
