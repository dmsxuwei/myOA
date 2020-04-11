package com.dms.oa.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dms.oa.dao.MateriaDao;
import com.dms.oa.po.Materialmanage;
import com.dms.oa.po.Materielcatagory;

@Component
public class MateriaService {
	
	@Resource
	private MateriaDao materiaDao;
	
	public List<Materialmanage> getMateria(String mat_id_search,
			String name_search, String addr_search, String manage_search,
			String isout_search, String page, String rows){
		return materiaDao.selectByExample(mat_id_search,name_search,addr_search,manage_search,isout_search,page,rows);	
	}
	
	public int insertMateria(Materialmanage materialmanage) {
		
		return materiaDao.insertMateria(materialmanage);
	}
	
	public int deleteByPrimaryKey(int i) {		
		return materiaDao.deleteByPrimaryKey(i);
	}
	
	
	public List<Materielcatagory> getMateriaCatagory(){
		return materiaDao.selectByExampleforCatagory();
	}
	
	public Materielcatagory getMateriaCatagorybyId(Integer id){
		return materiaDao.selectByPrimaryKey(id);
	}
	
}
