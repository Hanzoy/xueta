package com.hanzoy.xueta.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Reply {
    private Integer id;

    private Integer reid;

    private String reply;

    private Integer favor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Integer getFavor() {
        return favor;
    }

    public void setFavor(Integer favor) {
        this.favor = favor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", reid=").append(reid);
        sb.append(", reply=").append(reply);
        sb.append(", favor=").append(favor);
        sb.append("]");
        return sb.toString();
    }
}