package com.spring.oauth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/23 2:33 下午
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {
    private String userId;
    private String userName;
    private String userPass;

    private List<RoleBean> roleBeans = new ArrayList<>();
    private List<ResourceBean> resourceBeans = new ArrayList<>();

    public UserBean(String userName, String userPass) {
        this.userName = userName;
        this.userPass = userPass;
    }

    public UserBean(String userId, String userName, String userPass) {
        this.userId = userId;
        this.userName = userName;
        this.userPass = userPass;
    }

    public boolean havePermission(String resource) {
        return this.resourceBeans.stream().filter(resourceBean ->
                resourceBean.getResourceName().equals(resource))
                .count() > 0;
    }
}
