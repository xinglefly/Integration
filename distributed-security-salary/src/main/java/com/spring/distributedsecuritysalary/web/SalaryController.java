package com.spring.distributedsecuritysalary.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xingle
 * @Description:
 * @Date: 2022/5/23 2:34 下午
 */
@RestController
@RequestMapping("/salary")
public class SalaryController {

    @GetMapping("query")
    @PreAuthorize("hasAuthority('salary')")
    public String query(){
        return "salary";
    }
}
