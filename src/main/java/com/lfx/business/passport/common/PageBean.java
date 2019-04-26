package com.lfx.business.passport.common;

import java.io.Serializable;
import java.util.List;

/**
 * @author liufeixiang
 * @date 2019-05-09 20:54
 */
public class PageBean<T> implements Serializable {

    private static final long serialVersionUID = 375498317419828586L;

    private long total;

    private List<T> list;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
