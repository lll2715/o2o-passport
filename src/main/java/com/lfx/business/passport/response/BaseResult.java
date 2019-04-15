package com.lfx.business.passport.response;

import com.lfx.business.passport.constant.ReturnCode;

/**
 * Created by liufeixiang on 2019/3/14.
 */
public class BaseResult {

    private boolean success;//业务是否正常

    private String code;//状态码

    private String msg;//提示信息


    public BaseResult() {
        success = true;
        code = ReturnCode.SUCCESS.getCode();
        msg = ReturnCode.SUCCESS.getDesp();
    }

    public static BaseResult buildResult(){
        return new BaseResult();
    }

    public BaseResult code(String code){
        setCode(code);
        return this;
    }

    public BaseResult msg(String msg){
        setMsg(msg);
        return this;
    }

    public BaseResult success(boolean success){
        setSuccess(success);
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
