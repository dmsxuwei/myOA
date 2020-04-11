package com.dms.oa.mapper;

import com.dms.oa.po.Materielcatagory;
import com.dms.oa.po.MaterielcatagoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MaterielcatagoryMapper {
    int countByExample(MaterielcatagoryExample example);

    int deleteByExample(MaterielcatagoryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Materielcatagory record);

    int insertSelective(Materielcatagory record);

    List<Materielcatagory> selectByExample(MaterielcatagoryExample example);

    Materielcatagory selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Materielcatagory record, @Param("example") MaterielcatagoryExample example);

    int updateByExample(@Param("record") Materielcatagory record, @Param("example") MaterielcatagoryExample example);

    int updateByPrimaryKeySelective(Materielcatagory record);

    int updateByPrimaryKey(Materielcatagory record);
}