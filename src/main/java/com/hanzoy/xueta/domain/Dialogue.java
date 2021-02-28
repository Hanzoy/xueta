package com.hanzoy.xueta.domain;

public class Dialogue {
    private Integer reid;

    private Integer npcid;

    private String content;

    private String picture;

    private Boolean iscontinue;

    private Integer nextid;

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public Integer getNpcid() {
        return npcid;
    }

    public void setNpcid(Integer npcid) {
        this.npcid = npcid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Boolean getIscontinue() {
        return iscontinue;
    }

    public void setIscontinue(Boolean iscontinue) {
        this.iscontinue = iscontinue;
    }

    public Integer getNextid() {
        return nextid;
    }

    public void setNextid(Integer nextid) {
        this.nextid = nextid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reid=").append(reid);
        sb.append(", npcid=").append(npcid);
        sb.append(", content=").append(content);
        sb.append(", picture=").append(picture);
        sb.append(", iscontinue=").append(iscontinue);
        sb.append(", nextid=").append(nextid);
        sb.append("]");
        return sb.toString();
    }
}