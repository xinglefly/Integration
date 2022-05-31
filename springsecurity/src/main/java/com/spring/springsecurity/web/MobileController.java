package com.spring.springsecurity.web;

import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/23 2:34 下午
 */
@Api(tags = "手机")
@RestController
@RequestMapping("/mobile")
public class MobileController {

    @Operation(summary = "query")
    @GetMapping("/query")
    public String query(){
        return "mobile";
    }
}
