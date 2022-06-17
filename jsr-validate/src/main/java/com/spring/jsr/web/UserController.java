package com.spring.jsr.web;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.spring.jsr.advice.Color;
import com.spring.jsr.domain.Colors;
import com.spring.jsr.domain.User;
import com.spring.jsr.record.Rest;
import com.spring.jsr.record.RestBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@Slf4j
@Api(tags = "用户管理")
@RestController
@RequestMapping("/users")
public class UserController {

    // 创建线程安全的Map，模拟users信息的存储
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<>());

    @Value("${datasource.password:}")
    private String source;

    @GetMapping("/getAllUsers")
    @Operation(summary = "获取用户列表")
    public Rest<?> getUsers(){
        List<User> r = new ArrayList<>(users.values());
        return RestBody.okData(r);
    }

    @PostMapping("/create")
    @Operation(summary = "创建用户")
    @ApiOperationSupport(author = "振兴")
    public Rest<?> postUser(@Valid @RequestBody User user){
        log.info("user:{}",user);
        users.put(user.getId(), user);
        return RestBody.okData(user);
    }

    @GetMapping("/getUserByID/{id}")
    @Operation(summary = "根据url的id来获取用户详细信息")
    @ApiOperationSupport(author = "振兴")
    public Rest<?> getUserById(@PathVariable Long id){
        if (id == null || "".equals(id)) {
            return RestBody.failure("id不能为空!");
        }
        User user = users.get(id);
        if (user == null) {
            return RestBody.failure("用户不存在!");
        }
        return RestBody.okData(user);
    }


    @GetMapping("/getJasypt")
    @ApiOperationSupport(author = "007")
    @Operation(summary = "获取加密信息")
    public Rest<?> getJasypt(){
        return RestBody.okData(this.source);
    }


    @GetMapping("/getColor/{color}")
    @ApiOperationSupport(author = "振兴")
    @Operation(summary = "获取颜色")
    public Rest<?> getOrderStatus(@Valid @Color({Colors.RED, Colors.YELLOW}) @PathVariable String color){
        return RestBody.okData(color);
    }
}

