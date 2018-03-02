package lsq.model;

import java.util.Date;

public class Credit {
    private String id;

    private String credit;

    private Long integral;

    private Long allIntegral;

    private Date updateTime;

    private Date creatTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit == null ? null : credit.trim();
    }

    public Long getIntegral() {
        return integral;
    }

    public void setIntegral(Long integral) {
        this.integral = integral;
    }

    public Long getAllIntegral() {
        return allIntegral;
    }

    public void setAllIntegral(Long allIntegral) {
        this.allIntegral = allIntegral;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}