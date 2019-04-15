package com.lfx.business.passport.domain.entity;

import java.util.Date;

public class Voucher {
    private Long id;

    private String ticketId;

    private Date created;

    private Date modified;

    private Short status;

    private Short yn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId == null ? null : ticketId.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public Short getYn() {
        return yn;
    }

    public void setYn(Short yn) {
        this.yn = yn;
    }

    @Override
    public String toString() {
        return "Voucher{" +
                "id=" + id +
                ", ticketId='" + ticketId + '\'' +
                ", created=" + created +
                ", modified=" + modified +
                ", status=" + status +
                ", yn=" + yn +
                '}';
    }
}