package com.dms.oa.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dms.oa.po.Materialmanage;
import com.dms.oa.po.Materielcatagory;
import com.dms.oa.po.Unittest;
import com.dms.oa.service.MateriaService;
import com.dms.oa.service.UnittestService;

@Controller
public class MateriaController {
	
	@Resource
	private MateriaService materiaService;
	
	
	@RequestMapping("/getMat.do")
	@ResponseBody
	public String getMat(HttpServletRequest request) throws Exception {
		System.out.println("getMat.do");
		List<Materielcatagory> materielcatagorys=materiaService.getMateriaCatagory();
		StringBuilder sb=new StringBuilder();
		 sb.append("[");
		 
		for(int i=0;i<materielcatagorys.size();i++){
			sb.append("{\"id\":"+"\""+materielcatagorys.get(i).getId()+"\","
					  +"\"text\":"+"\""+materielcatagorys.get(i).getCatagoryname()+"\"}");
			if(i<materielcatagorys.size()-1) sb.append(",");
		}
		 sb.append("]");
		String json="[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	
	@RequestMapping("/toMateria.do")
	//@ResponseBody
	public String toMateria(HttpServletRequest request) throws Exception {
		System.out.println("toMateria.do");
		return "materia/materia";
	}
	
	@RequestMapping("/getMateria.do")
	@ResponseBody
	public String getMateria(HttpServletRequest request) throws Exception {
		  String page=request.getParameter("page");
		  //每页显示的记录数
		  String rows=request.getParameter("rows"); 
		  
		  String mat_id_search=request.getParameter("mat_id_search"); 
		  String name_search=request.getParameter("name_search");
		  String addr_search=request.getParameter("addr_search");
		  String manage_search=request.getParameter("manage_search");
		  String isout_search=request.getParameter("isout_search");

		  System.out.println("mat_id_search===>:"+mat_id_search);
		  System.out.println("name_search===>:"+name_search);
		  System.out.println("addr_search===>:"+addr_search);
		  System.out.println("manage_search===>:"+manage_search);
		  System.out.println("isout_search===>:"+isout_search);
		  
		  System.out.println("page===>:"+page);
		  System.out.println("rows===>:"+rows);

	 //查出物料分类
	 Map materielcatagorysMap=new HashMap();
     List<Materielcatagory> materielcatagorys=materiaService.getMateriaCatagory();
     for(int i=0;i<materielcatagorys.size();i++){
    	 materielcatagorysMap.put(materielcatagorys.get(i).getId(), materielcatagorys.get(i).getCatagoryname());
     }
		  
		  
	 List<Materialmanage> materias= materiaService.getMateria(mat_id_search,name_search,addr_search,manage_search,isout_search,page,rows);
	 System.out.println("getGrid.do"+materias.size());
	 StringBuilder sb=new StringBuilder();
	 sb.append("{\"total\":9,\"rows\":");
	 sb.append("[");
for(int i=0;i<materias.size();i++){

	String isout="";	 
	if(null==materias.get(i).getIsout()||"".equals(materias.get(i).getIsout()))	{
		isout="否";
	}else if (materias.get(i).getIsout()==1){
		isout="是";
	}else if(materias.get(i).getIsout()==0){
		isout="否";
	}
	
	
	 sb.append("{\"name\":\""+materias.get(i).getName()
			    +"\",\"mat_id\":\""+materielcatagorysMap.get(materias.get(i).getMatId())
			 	+"\",\"number\":\""+materias.get(i).getNumber()
			 	+"\",\"count\":\""+materias.get(i).getCount()
			 	+"\",\"addr\":\""+materias.get(i).getAddr()
			 	+"\",\"manage\":\""+materias.get(i).getManage()
			 	+"\",\"warehousingtime\":\""+materias.get(i).getWarehousingtime()
			 	+"\",\"isout\":\""+isout
			 	+"\",\"outtime\":\""+materias.get(i).getOuttime()
			 	+"\",\"iscompose\":\""+materias.get(i).getIscompose()
			 	+"\",\"composeid\":\""+materias.get(i).getComposeid()
			 	+"\",\"price\":\""+materias.get(i).getPrice()
			 	+"\",\"id\":\""+materias.get(i).getId()
			 	+"\"}");
	if(i<materias.size()-1) sb.append(",");
	 }
	// sb.append(",");
	 sb.append("]}");

	return sb.toString();
		//String json="{\"total\":1,\"rows\":[{\"id\":\"001\",\"name\":\"admin\",\"password\":\"password\"}]}";
		//return json;
	}
	
	
	@RequestMapping("/delMateria.do")
	@ResponseBody
	public String delUnittest(HttpServletRequest request) throws Exception {
		String id=request.getParameter("id");
		
	int rs=materiaService.deleteByPrimaryKey(Integer.parseInt(id));
	return "[{\"result\":\"OK\"}]";
	}

	@RequestMapping("/addmateria.do")
	@ResponseBody
	public String addmateria(HttpServletRequest request) throws Exception {
		System.out.println("addmateria.do:"+request.getParameter("mat_id"));
		
		Materialmanage materialmanage=new Materialmanage();
		materialmanage.setMatId(Integer.parseInt(request.getParameter("mat_id")));
		
	
		materialmanage.setName(request.getParameter("name"));
		materialmanage.setNumber(request.getParameter("number"));
		materialmanage.setCount(Integer.parseInt(request.getParameter("count")));
		materialmanage.setAddr(request.getParameter("addr"));
		materialmanage.setManage(request.getParameter("manage"));
		materialmanage.setIsout(0);
		materialmanage.setPrice((long)Integer.parseInt(request.getParameter("price")));

		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm");
		String warehousingtime=request.getParameter("warehousingtime");
		System.out.println(warehousingtime);
		Date date=new Date();
		date=sdf.parse(warehousingtime);
		materialmanage.setWarehousingtime(date);

		materiaService.insertMateria(materialmanage);
		
		String json="[{\"id\":\"0\",\"text\":\"不通过\"},{\"id\":\"1\",\"text\":\"通过\"}]";
		return json;
	}
	
	

}
