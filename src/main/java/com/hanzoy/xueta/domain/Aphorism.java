package com.hanzoy.xueta.domain;

public class Aphorism {
    private Integer id;

    private String aphorism;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAphorism() {
        return aphorism;
    }

    public void setAphorism(String aphorism) {
        this.aphorism = aphorism;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", aphorism=").append(aphorism);
        sb.append("]");
        return sb.toString();
    }
}