package com.hanzoy.xueta.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Role {
    private Integer id;

    private String name;

    private String dynasty;

    private String tradename;

    private String picture;

    private String portrait;

    private String description;

    private Integer price;

    private Integer favor;

    @JsonProperty("isDialogue")
    private Boolean isdialogue;
    @JsonProperty("isHaving")
    private Boolean ishaving;

    @JsonIgnore
    private Integer reid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDynasty() {
        return dynasty;
    }

    public void setDynasty(String dynasty) {
        this.dynasty = dynasty;
    }

    public String getTradename() {
        return tradename;
    }

    public void setTradename(String tradename) {
        this.tradename = tradename;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getFavor() {
        return favor;
    }

    public void setFavor(Integer favor) {
        this.favor = favor;
    }

    public Boolean getIsdialogue() {
        return isdialogue;
    }

    public void setIsdialogue(Boolean isdialogue) {
        this.isdialogue = isdialogue;
    }

    public Boolean getIshaving() {
        return ishaving;
    }

    public void setIshaving(Boolean ishaving) {
        this.ishaving = ishaving;
    }

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", dynasty=").append(dynasty);
        sb.append(", tradename=").append(tradename);
        sb.append(", picture=").append(picture);
        sb.append(", portrait=").append(portrait);
        sb.append(", description=").append(description);
        sb.append(", price=").append(price);
        sb.append(", favor=").append(favor);
        sb.append(", isdialogue=").append(isdialogue);
        sb.append(", ishaving=").append(ishaving);
        sb.append(", reid=").append(reid);
        sb.append("]");
        return sb.toString();
    }
}