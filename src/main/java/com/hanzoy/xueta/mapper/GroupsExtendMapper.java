package com.hanzoy.xueta.mapper;

import com.hanzoy.xueta.domain.Groups;
import com.hanzoy.xueta.dto.IdAndTimeInfo;

import java.util.List;

public interface GroupsExtendMapper extends GroupsMapper{
    List<IdAndTimeInfo> getEmerging();
    List<IdAndTimeInfo> getGeneral();
    void setZero();
}
