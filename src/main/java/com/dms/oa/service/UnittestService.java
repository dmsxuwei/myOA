package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.UnittestDao;
import com.dms.oa.po.Unittest;

@Component
public class UnittestService {
	
	@Resource
	private UnittestDao unittestDao;
	
	public List<Unittest> getUnittest(){
		return unittestDao.selectByExample();	
	}
	
	public int insertUnittest(Unittest unittest) {
		
		return unittestDao.insertUnittest(unittest);
	}
	
public int deleteByPrimaryKey(int i) {
		
		return unittestDao.deleteByPrimaryKey(i);
	}
	
}
