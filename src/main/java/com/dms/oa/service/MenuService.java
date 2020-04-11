package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.MenuDao;
import com.dms.oa.po.Resources;

@Component
public class MenuService {
	@Resource
	private MenuDao menuDao;
	
	public List<Resources> getMenu(){
		return menuDao.selectByExample();		
	}

}
