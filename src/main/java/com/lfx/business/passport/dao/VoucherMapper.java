package com.lfx.business.passport.dao;

import com.lfx.business.passport.domain.entity.Voucher;

public interface VoucherMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Voucher record);

    int insertSelective(Voucher record);

    Voucher selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Voucher record);

    int updateByPrimaryKey(Voucher record);

    Voucher selectOneEffectiveRecord();

    int updateStatusIsUsed(Long id);
}