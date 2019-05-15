package com.lfx.business.passport.controller;

import com.lfx.business.passport.domain.User;
import com.lfx.business.passport.domain.UserParamVmo;
import com.lfx.business.passport.service.TestMybatisService;
import com.lfx.business.passport.service.UserService;
import com.lfx.business.passport.service.impl.AccountServiceImpl;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by liufeixiang on 2019/3/12.
 */
@RestController
@RequestMapping("/user")
@Slf4j
@Api(value = "用户表")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountServiceImpl accountService;

    @ApiOperation(value = "查询所有")
    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    public Object selectAllUserInfo(){
        log.info("UserController.selectAllUserInfo start ...");
        List<User> list = userService.selectAll();
        return list;
    }


    @ApiOperation(value = "插入数据")
    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public Object insert(){
        log.info("UserController.insert start ...");
        User user = new User();
        user.setAge(12);
        user.setName("saada");
        userService.insertOne(user);
        return "success";
    }


//    @RequestMapping(value = "/setCache",method = RequestMethod.GET)
//    @ResponseBody
//    public void setCache(){
//        Account account = new Account("7878");
//        accountService.setCache(account);
//    }
//
//    @RequestMapping(value = "/getCache",method = RequestMethod.GET)
//    @ResponseBody
//    public Account getCache(){
//        log.info("getCache start");
//        return accountService.getCache();
//    }

    @ApiOperation(value = "查询所有")
    @PostMapping(value = "/selectByCondition")
    public Object selectByCondition(@RequestBody UserParamVmo userParamVmo){
        return userService.selectByCondition(userParamVmo);
    }


    @Autowired
    private TestMybatisService testMybatisService;

    @ApiOperation(value = "查询所有")
    @GetMapping(value = "test")
    public void test(){
        log.info(testMybatisService.selectByCondition().toString());
    }

}
