package com.lfx.business.passport.service;

import com.lfx.business.passport.domain.Account;

/**
 * Created by liufeixiang on 2019/3/20.
 */
public interface AccountService {

    public Account getAccountByName(String accountName);

    public void reload();
}
