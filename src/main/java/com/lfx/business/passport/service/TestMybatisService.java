package com.lfx.business.passport.service;

import com.lfx.business.passport.domain.entity.TestMybatis;

import java.util.List;

public interface TestMybatisService {

    List<TestMybatis> selectByCondition();
}
