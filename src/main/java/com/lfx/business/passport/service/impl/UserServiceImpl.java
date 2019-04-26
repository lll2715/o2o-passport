package com.lfx.business.passport.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lfx.business.passport.common.PageBean;
import com.lfx.business.passport.dao.UserDao;
import com.lfx.business.passport.domain.User;
import com.lfx.business.passport.domain.UserParamVmo;
import com.lfx.business.passport.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liufeixiang on 2019/3/15.
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public void insertOne(User user) {
        userDao.insertOne(user);
    }

    @Override
    public PageBean<User> selectByCondition(UserParamVmo userParamVmo) {
        PageBean<User> pageBean = new PageBean<>();
        Page page = PageHelper.startPage(userParamVmo.getPageNum(),userParamVmo.getPageSize());
        pageBean.setList(userDao.selectByCondition(userParamVmo));
        pageBean.setTotal(page.getTotal());
        return pageBean;
    }
}
