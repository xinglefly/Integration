package com.spring.distributedsecurityuaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/25 7:09 下午
 */
@Configuration
public class TokenConfig {
    @Bean
    public TokenStore tokenStore(){
        //使用基于内存的普通令牌
        return new InMemoryTokenStore();
    }
}
