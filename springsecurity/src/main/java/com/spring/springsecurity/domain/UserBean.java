package com.spring.springsecurity.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/23 2:33 下午
 */
@ApiModel("用户")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBean {

    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户密码")
    private String userPass;


}
