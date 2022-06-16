package com.spring.jsr.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@ApiModel("用户")
public class User {

    private Long id;

    @NotBlank(message = "用户名不能为空!")
    @Size(min = 2, max = 5)
    @ApiModelProperty("用户名")
    private String name;

    @NotNull(message = "年龄不能为空!")
    @Min(value = 10, message = "年龄大于18!")
    @Max(value = 100,message = "年龄小于100!")
    @ApiModelProperty("年龄")
    private Integer age;

    @NotBlank(message = "邮箱不能为空!")
    @Email
    @ApiModelProperty("邮箱")
    private String email;
}
