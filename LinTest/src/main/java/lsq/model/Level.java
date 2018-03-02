package lsq.model;

import java.util.Date;

public class Level {
    private String id;

    private Long activeDay;

    private Long allDay;

    private Integer level;

    private Long upgrade;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Long getActiveDay() {
        return activeDay;
    }

    public void setActiveDay(Long activeDay) {
        this.activeDay = activeDay;
    }

    public Long getAllDay() {
        return allDay;
    }

    public void setAllDay(Long allDay) {
        this.allDay = allDay;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(Long upgrade) {
        this.upgrade = upgrade;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}