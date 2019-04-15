package com.lfx.business.passport.constant;

/**
 * Created by liufeixiang on 2019/3/14.
 */
public enum ReturnCode {
    SUCCESS("000","成功");

    private String code;

    private String desp;

    ReturnCode(String code, String desp) {
        this.code = code;
        this.desp = desp;
    }

    public String getCode() {
        return code;
    }

    public String getDesp() {
        return desp;
    }
}
