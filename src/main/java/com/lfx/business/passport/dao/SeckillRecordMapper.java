package com.lfx.business.passport.dao;

import com.lfx.business.passport.domain.entity.SeckillRecord;

public interface SeckillRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(SeckillRecord record);

    int insertSelective(SeckillRecord record);

    SeckillRecord selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SeckillRecord record);

    int updateByPrimaryKey(SeckillRecord record);
}