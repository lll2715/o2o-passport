package com.lfx.business.passport.service;

import com.lfx.business.passport.domain.entity.Voucher;
import com.lfx.business.passport.response.BaseResult;

/**
 * Created by liufeixiang on 2019/3/30.
 */
public interface VoucherService {

    /**
     * 领取券码
     * @return
     */
    Voucher receiveVoucher();

    BaseResult getVoucherRecord();


}
