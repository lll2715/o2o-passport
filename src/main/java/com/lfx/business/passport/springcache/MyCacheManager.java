package com.lfx.business.passport.springcache;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

import java.util.Collection;

/**
 * Created by liufeixiang on 2019/3/20.
 */
public class MyCacheManager extends AbstractCacheManager {

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return null;
    }
}
