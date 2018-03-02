package lsq.model;

import java.util.Date;

public class DpConsumerDetails {
    private String id;

    private Date date;

    private String time;

    private String consumptionRemark;

    private String consumptionType;

    private Float expenditure;

    private Float income;

    private String remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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

    public void setConsumptionRemark(String consumptionRemark) {
        this.consumptionRemark = consumptionRemark == null ? null : consumptionRemark.trim();
    }

    public String getConsumptionType() {
        return consumptionType;
    }

    public void setConsumptionType(String consumptionType) {
        this.consumptionType = consumptionType == null ? null : consumptionType.trim();
    }

    public Float getExpenditure() {
        return expenditure;
    }

    public void setExpenditure(Float expenditure) {
        this.expenditure = expenditure;
    }

    public Float getIncome() {
        return income;
    }

    public void setIncome(Float income) {
        this.income = income;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}