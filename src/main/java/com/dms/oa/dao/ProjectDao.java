package com.dms.oa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dms.oa.mapper.ProjectMapper;
import com.dms.oa.po.Project;
import com.dms.oa.po.ProjectExample;

@Component
public class ProjectDao {
	@Autowired
	private ProjectMapper projectMapper;
	
	
	 public List<Project> selectByExample(){
		 ProjectExample example =new ProjectExample();
		 example.setOrderByClause("projectid");
		return projectMapper.selectByExample(example); 
	 }
	 
	 public int countByExample(){
		 ProjectExample example =new ProjectExample();
		 return projectMapper.countByExample(example);
	 }
	 
	 
	 public int insertProject(Project project){
		 return projectMapper.insert(project);
	 }
	 
	 public int deleteByPrimaryKey(int id){
		 return projectMapper.deleteByPrimaryKey(id);
	 }
	 
}
