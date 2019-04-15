package com.lfx.business.passport.service.impl;

import com.google.common.base.Optional;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.lfx.business.passport.domain.Account;
import com.lfx.business.passport.domain.CacheContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by liufeixiang on 2019/3/20.
 */
@Slf4j
@Service("accountService")
public class AccountServiceImpl {

    @Resource
    private CacheContext<Account> accountCacheContext ;

    private Cache<String,Account> cache = CacheBuilder.newBuilder().build();

    public Account getAccountByName(String accountName) {
        Account result = accountCacheContext.get(accountName);
        if (result != null) {
            log.info("get from cache... {}", accountName);
            return result;
        }

        Optional<Account> accountOptional = getFromDB(accountName);
        if (!accountOptional.isPresent()) {
            throw new IllegalStateException(String.format("can not find account by account name : [%s]", accountName));
        }

        Account account = accountOptional.get();
        accountCacheContext.addOrUpdateCache(accountName, account);
        return account;
    }

    public void reload() {
        accountCacheContext.evictCache();
    }

    private Optional<Account> getFromDB(String accountName) {
        log.info("real querying db... {}", accountName);
        //Todo query data from database
        return Optional.fromNullable(new Account(accountName));
    }

    public void setCache(Account account){
        log.info("addOrUpdateCache start");
        accountCacheContext.addOrUpdateCache("abc", account);
        cache.put("abc", account);
    }

    public Account getCache(){
        log.info("getCache start");
        return accountCacheContext.get("abc");
    }
}
