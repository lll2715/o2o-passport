package com.lfx.business.passport.domain.entity;

import java.util.Date;

public class SeckillRecord {
    private String id;

    private String seckillItemId;

    private String userPhone;

    private Integer state;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSeckillItemId() {
        return seckillItemId;
    }

    public void setSeckillItemId(String seckillItemId) {
        this.seckillItemId = seckillItemId == null ? null : seckillItemId.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}