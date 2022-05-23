package com.spring.oauth.service;

import com.spring.oauth.domain.UserBean;
import com.spring.oauth.util.TestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @Author: xingle
 * @Description: 来对登陆进行认证
 * @Date: 2022/5/23 2:35 下午
 */
@Service
public class AuthService {

    @Autowired
    private TestData testData;

    public UserBean query(UserBean user) {
        UserBean userBean = testData.queryUser(user);
        if (null != userBean) {
            userBean.setUserId(UUID.randomUUID().toString());
        }
        return userBean;
    }
}
