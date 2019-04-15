package com.lfx.business.passport.exception;

import com.lfx.business.passport.response.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by liufeixiang on 2019/3/14.
 * 全局异常处理，捕获所有Controller中抛出的异常。
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //处理自定义的异常
    @ExceptionHandler(PassportException.class)
    @ResponseBody
    public Object customHandler(PassportException e){
        log.error("customHandler error",e);
        return BaseResult.buildResult().code(e.getCode()).msg(e.getMessage());
    }

    //其他未处理的异常
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception e){
        log.error("exceptionHandler error",e);
        ModelAndView mv = new ModelAndView("error/500");
        return mv;
    }

}
