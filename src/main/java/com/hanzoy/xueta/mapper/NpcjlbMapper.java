package com.hanzoy.xueta.mapper;

import com.hanzoy.xueta.domain.Npcjlb;
import com.hanzoy.xueta.domain.NpcjlbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NpcjlbMapper {
    long countByExample(NpcjlbExample example);

    int deleteByExample(NpcjlbExample example);

    int deleteByPrimaryKey(@Param("userid") Integer userid, @Param("npcid") Integer npcid);

    int insert(Npcjlb record);

    int insertSelective(Npcjlb record);

    List<Npcjlb> selectByExample(NpcjlbExample example);

    Npcjlb selectByPrimaryKey(@Param("userid") Integer userid, @Param("npcid") Integer npcid);

    int updateByExampleSelective(@Param("record") Npcjlb record, @Param("example") NpcjlbExample example);

    int updateByExample(@Param("record") Npcjlb record, @Param("example") NpcjlbExample example);

    int updateByPrimaryKeySelective(Npcjlb record);

    int updateByPrimaryKey(Npcjlb record);
}