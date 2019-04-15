package com.lfx.business.passport.controller;

import com.lfx.business.passport.domain.User;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liufeixiang on 2019/3/12.
 */
@Slf4j
@Controller
@Api(value="/index",description="首页测试")
public class IndexController {

    @ApiOperation(value="接口说明(测试)",httpMethod="GET",notes="测试GET")
    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public User test(@ApiParam(required = true, name = "name", value = "用户名") @RequestParam String name){
        log.info("name="+name);
        User user = new User();
        user.setName(name);
        return user;
    }

}
