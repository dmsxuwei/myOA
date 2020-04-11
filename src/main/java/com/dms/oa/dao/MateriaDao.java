package com.dms.oa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oa.mapper.MaterialmanageMapper;
import com.dms.oa.mapper.MaterielcatagoryMapper;
import com.dms.oa.po.Materialmanage;
import com.dms.oa.po.MaterialmanageExample;
import com.dms.oa.po.MaterialmanageExample.Criteria;
import com.dms.oa.po.Materielcatagory;
import com.dms.oa.po.MaterielcatagoryExample;

@Component
public class MateriaDao {
	@Autowired
	private MaterialmanageMapper materialmanageMapper;
	@Autowired
	private MaterielcatagoryMapper materielcatagoryMapper;
	
	
	 public List<Materialmanage> selectByExample(String mat_id_search,String name_search,
				String addr_search,String manage_search,String isout_search,String page,String rows){
		 MaterialmanageExample example =new MaterialmanageExample();
		 Criteria criteria=example.createCriteria();
		 if(null!=mat_id_search&&!"".equals(mat_id_search)) criteria.andMatIdEqualTo(Integer.parseInt(mat_id_search));
		 if(null!=name_search&&!"".equals(name_search)) criteria.andNameEqualTo(name_search);
		 if(null!=addr_search&&!"".equals(addr_search)) criteria.andAddrEqualTo(addr_search);
		 if(null!=manage_search&&!"".equals(manage_search)) criteria.andManageEqualTo(manage_search);
		 if(null!=isout_search&&!"".equals(isout_search)) criteria.andIsoutEqualTo(Integer.parseInt(isout_search));
		 
		 
		 //example.createCriteria().andAddrEqualTo("");
		 example.setOrderByClause("warehousingtime");
		return materialmanageMapper.selectByExample(example); 
	 }
	 
	 public int insertMateria(Materialmanage materialmanage){
		 return materialmanageMapper.insert(materialmanage);
	 }
	 
	 public int deleteByPrimaryKey(int id){
		 return materialmanageMapper.deleteByPrimaryKey(id);
	 }
	 
	 
	 public List<Materielcatagory> selectByExampleforCatagory(){
		 MaterielcatagoryExample example =new MaterielcatagoryExample();
		 return materielcatagoryMapper.selectByExample(example);
	 }
	 
	 public Materielcatagory selectByPrimaryKey(Integer id){
		 return materielcatagoryMapper.selectByPrimaryKey(id);
	 }


	 
}
