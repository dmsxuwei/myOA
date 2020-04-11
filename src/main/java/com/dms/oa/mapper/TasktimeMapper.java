package com.dms.oa.mapper;

import com.dms.oa.po.Tasktime;
import com.dms.oa.po.TasktimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TasktimeMapper {
    int countByExample(TasktimeExample example);

    int deleteByExample(TasktimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Tasktime record);

    int insertSelective(Tasktime record);

    List<Tasktime> selectByExample(TasktimeExample example);

    Tasktime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Tasktime record, @Param("example") TasktimeExample example);

    int updateByExample(@Param("record") Tasktime record, @Param("example") TasktimeExample example);

    int updateByPrimaryKeySelective(Tasktime record);

    int updateByPrimaryKey(Tasktime record);
}