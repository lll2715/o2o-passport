package com.lfx.business.passport.service;

import com.lfx.business.passport.domain.User;

import java.util.List;

/**
 * Created by liufeixiang on 2019/3/15.
 */
public interface UserService {

    List<User> selectAll();

    void insertOne(User user);
}
