package com.atguigu.yygh.hospset.controller;

import com.atguigu.yygh.commons.result.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * @author Wldz
 * @version 1.0.0
 * @description TODO
 * @date 23-6-29 1:14
 */
@Api("临时用户接口")
@CrossOrigin
@RestController
@RequestMapping("/admin/hosp/user")
public class UserLoginTestController {

    @ApiOperation("临时用户登录接口")
    @PostMapping("login")
    public R login(){
        return R.suc().data("token","admin-token");
    }
    @ApiOperation("临时用户信息接口")
    @GetMapping("info")
    public R info(){
        return R.suc()
                .data("roles", Arrays.asList("admin"))
                .data("introduction","I am a super administrator")
                .data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif")
                .data("name","LDZ");
    }
}

