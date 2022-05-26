package com.spring.distributedsecurityuaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

@SpringBootApplication
@EnableAuthorizationServer
public class DistributedSecurityUaaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedSecurityUaaApplication.class, args);
    }

}
