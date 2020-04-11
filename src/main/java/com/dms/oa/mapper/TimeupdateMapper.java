package com.dms.oa.mapper;

import com.dms.oa.po.Timeupdate;
import com.dms.oa.po.TimeupdateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TimeupdateMapper {
    int countByExample(TimeupdateExample example);

    int deleteByExample(TimeupdateExample example);

    int deleteByPrimaryKey(Integer recordid);

    int insert(Timeupdate record);

    int insertSelective(Timeupdate record);

    List<Timeupdate> selectByExample(TimeupdateExample example);

    Timeupdate selectByPrimaryKey(Integer recordid);

    int updateByExampleSelective(@Param("record") Timeupdate record, @Param("example") TimeupdateExample example);

    int updateByExample(@Param("record") Timeupdate record, @Param("example") TimeupdateExample example);

    int updateByPrimaryKeySelective(Timeupdate record);

    int updateByPrimaryKey(Timeupdate record);
}