package com.dms.oa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oa.mapper.UnittestMapper;
import com.dms.oa.po.Unittest;
import com.dms.oa.po.UnittestExample;

@Component
public class UnittestDao {
	@Autowired
	private UnittestMapper unittestMapper;
	
	
	 public List<Unittest> selectByExample(){
		 UnittestExample example =new UnittestExample();
		 example.setOrderByClause("testtime");
		return unittestMapper.selectByExample(example); 
	 }
	 
	 public int insertUnittest(Unittest unittest){
		 return unittestMapper.insert(unittest);
	 }
	 
	 public int deleteByPrimaryKey(int id){
		 return unittestMapper.deleteByPrimaryKey(id);
	 }
	 
}
