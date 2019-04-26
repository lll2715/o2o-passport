package com.lfx.business.passport.domain;

import com.lfx.business.passport.common.BaseParamVmo;

/**
 * @author liufeixiang
 * @date 2019-05-09 20:58
 */
public class UserParamVmo extends BaseParamVmo {

    private int id;

    private int age;

    private String name;

    private byte yn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getYn() {
        return yn;
    }

    public void setYn(byte yn) {
        this.yn = yn;
    }
}
