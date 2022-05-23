package com.spring.oauth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xingle
 * @Description:
 * Spring Security中，资源被简化成一个字符串。
 * 而在自己设计资源时，可以设计不同类型的资源控制不同的行为。
 * 例如 菜单资源，Rest接口资源，页面控件资源等。
 * @Date: 2022/5/23 2:32 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceBean {
    private String resourceId;
    private String resourceName;
    private String resourceType;

    public ResourceBean(String resourceId, String resourceName) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
    }
}
