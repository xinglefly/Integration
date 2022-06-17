package com.spring.jsr.domain;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @desc:
 * @author: xingle
 * @date: 2022/6/17
 */
@Data
public class Role {

    private Long roleId;

    @NotBlank(message = "角色名称不能为空")
    private String roleName;

}
