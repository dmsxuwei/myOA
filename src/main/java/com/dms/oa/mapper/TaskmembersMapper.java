package com.dms.oa.mapper;

import com.dms.oa.po.Taskmembers;
import com.dms.oa.po.TaskmembersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskmembersMapper {
    int countByExample(TaskmembersExample example);

    int deleteByExample(TaskmembersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Taskmembers record);

    int insertSelective(Taskmembers record);

    List<Taskmembers> selectByExample(TaskmembersExample example);

    Taskmembers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Taskmembers record, @Param("example") TaskmembersExample example);

    int updateByExample(@Param("record") Taskmembers record, @Param("example") TaskmembersExample example);

    int updateByPrimaryKeySelective(Taskmembers record);

    int updateByPrimaryKey(Taskmembers record);
}