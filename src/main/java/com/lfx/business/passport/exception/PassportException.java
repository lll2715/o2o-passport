package com.lfx.business.passport.exception;

/**
 * Created by liufeixiang on 2019/3/14.
 */
public class PassportException extends RuntimeException {

    private String code;

    public PassportException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
