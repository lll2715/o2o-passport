package com.lfx.business.passport.service.impl;

import com.lfx.business.passport.dao.TestMybatisMapper;
import com.lfx.business.passport.domain.entity.TestMybatis;
import com.lfx.business.passport.domain.entity.TestMybatisExample;
import com.lfx.business.passport.service.TestMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liufeixiang
 * @date 2019-05-14 20:51
 */
@Service
public class TestMybatisServiceImpl implements TestMybatisService {

    @Autowired
    private TestMybatisMapper testMybatisMapper;

    @Override
    public  List<TestMybatis> selectByCondition() {
        TestMybatisExample example = new TestMybatisExample();
        example.setOrderByClause("created desc");
        return testMybatisMapper.selectByExample(example);
    }
}
