package com.lfx.business.passport.domain;

import java.util.Date;

/**
 * Created by liufeixiang on 2019/3/15.
 */
public class User {

    private int id;

    private int age;

    private String name;

    private Date created;

    private Date modified;

    private byte yn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public byte getYn() {
        return yn;
    }

    public void setYn(byte yn) {
        this.yn = yn;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", yn=" + yn +
                '}';
    }
}
