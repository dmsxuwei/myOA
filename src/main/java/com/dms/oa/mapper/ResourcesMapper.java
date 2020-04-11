package com.dms.oa.mapper;

import com.dms.oa.po.Resources;
import com.dms.oa.po.ResourcesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourcesMapper {
    int countByExample(ResourcesExample example);

    int deleteByExample(ResourcesExample example);

    int deleteByPrimaryKey(Integer resourceid);

    int insert(Resources record);

    int insertSelective(Resources record);

    List<Resources> selectByExample(ResourcesExample example);

    Resources selectByPrimaryKey(Integer resourceid);

    int updateByExampleSelective(@Param("record") Resources record, @Param("example") ResourcesExample example);

    int updateByExample(@Param("record") Resources record, @Param("example") ResourcesExample example);

    int updateByPrimaryKeySelective(Resources record);

    int updateByPrimaryKey(Resources record);
}