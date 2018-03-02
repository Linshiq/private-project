package lsq.model;

import java.util.Date;

public class DpUserBalance {
    private Date date;

    private Float totalConsumption;

    private Float totalIncome;

    private Float balance;

    private String registrar;

    private String remark;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Float getTotalConsumption() {
        return totalConsumption;
    }

    public void setTotalConsumption(Float totalConsumption) {
        this.totalConsumption = totalConsumption;
    }

    public Float getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Float totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public String getRegistrar() {
        return registrar;
    }

    public void setRegistrar(String registrar) {
        this.registrar = registrar == null ? null : registrar.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}