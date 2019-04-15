package com.lfx.business.passport.domain;

import java.io.Serializable;

/**
 * Created by liufeixiang on 2019/3/20.
 */
public class Account implements Serializable{

    private static final long serialVersionUID = 8693245937102133731L;

    private int id;
    private String name;

    public Account(String name) {
        this.name = name;
    }

    public Account(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Account() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
