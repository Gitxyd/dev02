package com.rx.dao;

import com.rx.entity.MessageBoard;
import com.rx.entity.MessageBoardExample;
import com.rx.entity.MessageBoardWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageBoardMapper {
    long countByExample(MessageBoardExample example);

    int deleteByExample(MessageBoardExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessageBoardWithBLOBs record);

    int insertSelective(MessageBoardWithBLOBs record);

    List<MessageBoardWithBLOBs> selectByExampleWithBLOBs(MessageBoardExample example);

    List<MessageBoard> selectByExample(MessageBoardExample example);

    MessageBoardWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageBoardWithBLOBs record, @Param("example") MessageBoardExample example);

    int updateByExampleWithBLOBs(@Param("record") MessageBoardWithBLOBs record, @Param("example") MessageBoardExample example);

    int updateByExample(@Param("record") MessageBoard record, @Param("example") MessageBoardExample example);

    int updateByPrimaryKeySelective(MessageBoardWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(MessageBoardWithBLOBs record);

    int updateByPrimaryKey(MessageBoard record);
}