package com.lfx.business.passport.controller;

import com.lfx.business.passport.domain.Account;
import com.lfx.business.passport.domain.User;
import com.lfx.business.passport.service.UserService;
import com.lfx.business.passport.service.impl.AccountServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liufeixiang on 2019/3/12.
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountServiceImpl accountService;

    @RequestMapping(value = "/selectAll",method = RequestMethod.GET)
    @ResponseBody
    public Object selectAllUserInfo(){
        log.info("UserController.selectAllUserInfo start ...");
        List<User> list = userService.selectAll();
        return list;
    }


    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    @ResponseBody
    public Object insert(){
        log.info("UserController.insert start ...");
        User user = new User();
        user.setAge(12);
        user.setName("saada");
        userService.insertOne(user);
        return "success";
    }


    @RequestMapping(value = "/setCache",method = RequestMethod.GET)
    @ResponseBody
    public void setCache(){
        Account account = new Account("7878");
        accountService.setCache(account);
    }

    @RequestMapping(value = "/getCache",method = RequestMethod.GET)
    @ResponseBody
    public Account getCache(){
        log.info("getCache start");
        return accountService.getCache();
    }

}
