package com.dms.oa.mapper;

import com.dms.oa.po.Unittest;
import com.dms.oa.po.UnittestExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UnittestMapper {
    int countByExample(UnittestExample example);

    int deleteByExample(UnittestExample example);

    int deleteByPrimaryKey(Integer unittestid);

    int insert(Unittest record);

    int insertSelective(Unittest record);

    List<Unittest> selectByExample(UnittestExample example);

    Unittest selectByPrimaryKey(Integer unittestid);

    int updateByExampleSelective(@Param("record") Unittest record, @Param("example") UnittestExample example);

    int updateByExample(@Param("record") Unittest record, @Param("example") UnittestExample example);

    int updateByPrimaryKeySelective(Unittest record);

    int updateByPrimaryKey(Unittest record);
}