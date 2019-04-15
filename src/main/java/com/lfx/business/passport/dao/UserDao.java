package com.lfx.business.passport.dao;

import com.lfx.business.passport.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by liufeixiang on 2019/3/15.
 */
@Repository
public interface UserDao {

    List<User> selectAll();

    void insertOne(User user);
}
