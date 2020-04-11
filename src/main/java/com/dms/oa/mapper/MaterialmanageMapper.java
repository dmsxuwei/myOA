package com.dms.oa.mapper;

import com.dms.oa.po.Materialmanage;
import com.dms.oa.po.MaterialmanageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterialmanageMapper {
    int countByExample(MaterialmanageExample example);

    int deleteByExample(MaterialmanageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Materialmanage record);

    int insertSelective(Materialmanage record);

    List<Materialmanage> selectByExample(MaterialmanageExample example);

    Materialmanage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Materialmanage record, @Param("example") MaterialmanageExample example);

    int updateByExample(@Param("record") Materialmanage record, @Param("example") MaterialmanageExample example);

    int updateByPrimaryKeySelective(Materialmanage record);

    int updateByPrimaryKey(Materialmanage record);
}