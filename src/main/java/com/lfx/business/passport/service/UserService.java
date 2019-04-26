package com.lfx.business.passport.service;

import com.lfx.business.passport.common.PageBean;
import com.lfx.business.passport.domain.User;
import com.lfx.business.passport.domain.UserParamVmo;

import java.util.List;

/**
 * Created by liufeixiang on 2019/3/15.
 */
public interface UserService {

    List<User> selectAll();

    void insertOne(User user);

    PageBean<User> selectByCondition(UserParamVmo userParamVmo);
}
