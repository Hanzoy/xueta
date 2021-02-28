package com.hanzoy.xueta.mapper;

import com.hanzoy.xueta.domain.Dialogue;
import com.hanzoy.xueta.domain.DialogueExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DialogueMapper {
    long countByExample(DialogueExample example);

    int deleteByExample(DialogueExample example);

    int deleteByPrimaryKey(Integer reid);

    int insert(Dialogue record);

    int insertSelective(Dialogue record);

    List<Dialogue> selectByExample(DialogueExample example);

    Dialogue selectByPrimaryKey(Integer reid);

    int updateByExampleSelective(@Param("record") Dialogue record, @Param("example") DialogueExample example);

    int updateByExample(@Param("record") Dialogue record, @Param("example") DialogueExample example);

    int updateByPrimaryKeySelective(Dialogue record);

    int updateByPrimaryKey(Dialogue record);
}