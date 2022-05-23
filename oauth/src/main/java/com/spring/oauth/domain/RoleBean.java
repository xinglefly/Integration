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
@NoArgsConstructor
@AllArgsConstructor
public class RoleBean {
    private String roleId;
    private String roleName;
    private List<ResourceBean> roleResource = new ArrayList<>();

    public RoleBean(String roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }
}
