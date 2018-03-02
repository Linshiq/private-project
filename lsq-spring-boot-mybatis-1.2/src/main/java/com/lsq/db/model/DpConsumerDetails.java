package com.lsq.db.model;

import java.math.BigDecimal;

public class DpConsumerDetails {
    private String id;

    private String date;

    private String time;

    private String consumptionRemark;

    private String consumptionType;

    private BigDecimal expenditure;

    private BigDecimal income;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }

    public String getConsumptionRemark() {
        return consumptionRemark;
    }

    public void setConsumptionRemark(String consumption_Remark) {
        this.consumptionRemark = consumption_Remark == null ? null : consumption_Remark.trim();
    }

    public String getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(String consumption_Type) {
        this.consumptionType = consumption_Type == null ? null : consumption_Type.trim();
    }

    public BigDecimal getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(BigDecimal expenditure) {
        this.expenditure = expenditure;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}