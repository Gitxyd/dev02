package com.rx.dao;

import com.rx.entity.Selectedcourse;
import com.rx.entity.SelectedcourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelectedcourseMapper {
    long countByExample(SelectedcourseExample example);

    int deleteByExample(SelectedcourseExample example);

    int insert(Selectedcourse record);

    int insertSelective(Selectedcourse record);

    List<Selectedcourse> selectByExample(SelectedcourseExample example);

    int updateByExampleSelective(@Param("record") Selectedcourse record, @Param("example") SelectedcourseExample example);

    int updateByExample(@Param("record") Selectedcourse record, @Param("example") SelectedcourseExample example);
}