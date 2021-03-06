package com.spring.distributedsecurityuaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/25 7:09 下午
 */
@Configuration
public class TokenConfig {

    //jwt令牌
    private static final String SIGN_KEY="uaa";

    @Bean
    public TokenStore tokenStore(){
//        return new InMemoryTokenStore(); //使用基于内存的普通令牌
        return new JwtTokenStore(accessTokenConvert());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConvert() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGN_KEY);
        return converter;
    }


}
