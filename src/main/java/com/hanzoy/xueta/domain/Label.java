package com.hanzoy.xueta.domain;

public class Label {
    private Integer id;

    private Integer userid;

    private String label;

    private Integer weektime;

    private Integer alltime;

    private Integer weeknumber;

    private Integer allnumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getWeektime() {
        return weektime;
    }

    public void setWeektime(Integer weektime) {
        this.weektime = weektime;
    }

    public Integer getAlltime() {
        return alltime;
    }

    public void setAlltime(Integer alltime) {
        this.alltime = alltime;
    }

    public Integer getWeeknumber() {
        return weeknumber;
    }

    public void setWeeknumber(Integer weeknumber) {
        this.weeknumber = weeknumber;
    }

    public Integer getAllnumber() {
        return allnumber;
    }

    public void setAllnumber(Integer allnumber) {
        this.allnumber = allnumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", label=").append(label);
        sb.append(", weektime=").append(weektime);
        sb.append(", alltime=").append(alltime);
        sb.append(", weeknumber=").append(weeknumber);
        sb.append(", allnumber=").append(allnumber);
        sb.append("]");
        return sb.toString();
    }
}