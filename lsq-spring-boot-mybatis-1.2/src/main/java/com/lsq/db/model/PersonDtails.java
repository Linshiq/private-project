package com.lsq.db.model;

import java.math.BigDecimal;

public class PersonDtails {
    private String detailId;

    private String recordDate;

    private String relatifTime;

    private String detailType;

    private String detailRemark;

    private BigDecimal amount;

    private String remark;

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId == null ? null : detailId.trim();
    }

    public String getRecordDate() {
        return recordDate;
    }

    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate == null ? null : recordDate.trim();
    }

    public String getRelatifTime() {
        return relatifTime;
    }

    public void setRelatifTime(String relatifTime) {
        this.relatifTime = relatifTime == null ? null : relatifTime.trim();
    }

    public String getDetailType() {
        return detailType;
    }

    public void setDetailType(String detailType) {
        this.detailType = detailType == null ? null : detailType.trim();
    }

    public String getDetailRemark() {
        return detailRemark;
    }

    public void setDetailRemark(String detailRemark) {
        this.detailRemark = detailRemark == null ? null : detailRemark.trim();
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}