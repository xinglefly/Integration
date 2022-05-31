package com.spring.springsecurity.web;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/23 2:34 下午
 */
@Api(tags = "薪水")
@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Operation(summary = "查看薪水")
    @GetMapping("query")
    public String query(){
        return "salary";
    }
}
