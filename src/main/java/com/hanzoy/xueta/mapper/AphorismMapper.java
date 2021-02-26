package com.hanzoy.xueta.mapper;

import com.hanzoy.xueta.domain.Aphorism;
import com.hanzoy.xueta.domain.AphorismExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AphorismMapper {
    long countByExample(AphorismExample example);

    int deleteByExample(AphorismExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Aphorism record);

    int insertSelective(Aphorism record);

    List<Aphorism> selectByExampleWithBLOBs(AphorismExample example);

    List<Aphorism> selectByExample(AphorismExample example);

    Aphorism selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Aphorism record, @Param("example") AphorismExample example);

    int updateByExampleWithBLOBs(@Param("record") Aphorism record, @Param("example") AphorismExample example);

    int updateByExample(@Param("record") Aphorism record, @Param("example") AphorismExample example);

    int updateByPrimaryKeySelective(Aphorism record);

    int updateByPrimaryKeyWithBLOBs(Aphorism record);
}