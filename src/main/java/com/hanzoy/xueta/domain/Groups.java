package com.hanzoy.xueta.domain;

public class Groups {
    private Integer id;

    private Integer number;

    private Integer tdtime;

    private Integer alltime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getTdtime() {
        return tdtime;
    }

    public void setTdtime(Integer tdtime) {
        this.tdtime = tdtime;
    }

    public Integer getAlltime() {
        return alltime;
    }

    public void setAlltime(Integer alltime) {
        this.alltime = alltime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", number=").append(number);
        sb.append(", tdtime=").append(tdtime);
        sb.append(", alltime=").append(alltime);
        sb.append("]");
        return sb.toString();
    }
}