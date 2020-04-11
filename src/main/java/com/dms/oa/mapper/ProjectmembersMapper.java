package com.dms.oa.mapper;

import com.dms.oa.po.Projectmembers;
import com.dms.oa.po.ProjectmembersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectmembersMapper {
    int countByExample(ProjectmembersExample example);

    int deleteByExample(ProjectmembersExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Projectmembers record);

    int insertSelective(Projectmembers record);

    List<Projectmembers> selectByExample(ProjectmembersExample example);

    Projectmembers selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Projectmembers record, @Param("example") ProjectmembersExample example);

    int updateByExample(@Param("record") Projectmembers record, @Param("example") ProjectmembersExample example);

    int updateByPrimaryKeySelective(Projectmembers record);

    int updateByPrimaryKey(Projectmembers record);
}