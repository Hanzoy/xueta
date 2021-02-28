package com.hanzoy.xueta.domain;

public class Npcjlb {
    private Integer id;

    private Integer userid;

    private Integer npcid;

    private Boolean ishaving;

    private Integer favor;

    private Integer reid;

    private Boolean isdialogue;

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

    public Integer getNpcid() {
        return npcid;
    }

    public void setNpcid(Integer npcid) {
        this.npcid = npcid;
    }

    public Boolean getIshaving() {
        return ishaving;
    }

    public void setIshaving(Boolean ishaving) {
        this.ishaving = ishaving;
    }

    public Integer getFavor() {
        return favor;
    }

    public void setFavor(Integer favor) {
        this.favor = favor;
    }

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public Boolean getIsdialogue() {
        return isdialogue;
    }

    public void setIsdialogue(Boolean isdialogue) {
        this.isdialogue = isdialogue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userid=").append(userid);
        sb.append(", npcid=").append(npcid);
        sb.append(", ishaving=").append(ishaving);
        sb.append(", favor=").append(favor);
        sb.append(", reid=").append(reid);
        sb.append(", isdialogue=").append(isdialogue);
        sb.append("]");
        return sb.toString();
    }
}