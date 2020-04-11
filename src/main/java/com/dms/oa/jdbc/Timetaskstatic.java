package com.dms.oa.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.dms.oa.base.Excelopertion;
import com.dms.oa.po.Tasktime;
import com.dms.oa.util.TimeUtil;

@Component
public class Timetaskstatic {
		  @Resource
		   private DataSource dataSource;
		  @Resource
		   private JdbcTemplate jdbcTemplate;

			 //得到项目用时比例
		   public List<Map<String, Object>> getProjectTimeProportion(String date) {
			   String sql="select (select projectname from project where projectid=log.projectid) projectname, sum(usetime) alltime from log where week="+(TimeUtil.getWeek(new Date())-1)+" GROUP BY projectid";
			   List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
				return list;
		   }


		   //查出本月工作时间按项目排列
/*		   public void getWorktimebyproject(String date) {
			   String sql="select (select projectname from project where projectid=log.projectid) projectname,(select realname from user where userid=log.opertor) realname,sum(usetime) usetime from log  GROUP BY projectid,opertor";
			   List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			   System.out.println("realname:"+list.get(1).get("realname"));
				Excelopertion.excelWrite("d:\\test.xls",list);
		   }*/
		   
		 //查出本月工作时间按人排列
		   public List<Map<String, Object>> getWorktimebyopertor(String date,boolean isExport) {
			   System.out.println("============"+date.replace("-", ""));
			   String sql="select (select realname from user where userid=log.opertor) realname,"
			   		+ " (select projectname from project where projectid=log.projectid) projectname,"
			   		+ "sum(usetime) usetime "
			   		+ "from log "
			   		+ "where timeindex like '"+date.replace("-", "")+"%' GROUP BY opertor,projectid";
			   List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
			  // System.out.println("realname:"+list.get(1).get("realname"));
			   String[] title = { "项目名称", "员工姓名", "消耗工时" };
			if(isExport==true)	Excelopertion.excelWrite("d:\\工时.xls",list,title);
				return list;
		   }
		   
		   
		   
		   
		   
		   /*		   public void getStudent(Integer id) {
		   String sql="select count(*) from user";
		   int  count=jdbcTemplate.queryForObject(sql, Integer.class);
		   System.out.println("count:"+count);
		   
		   String sql2="select * from user where userid=?";
		   Map map=jdbcTemplate.queryForMap(sql2,new Object[]{new Integer(1)},new int[]{ Types.INTEGER});
		   System.out.println("realname:"+map.get("realname"));
		   
		   String sql3="select * from user where userid!=?";
		   List<Map<String, Object>> list=jdbcTemplate.queryForList(sql3,new Object[]{new Integer(12)},new int[]{ Types.INTEGER});
		   System.out.println("realname:"+list.get(1).get("realname"));
		   
	   }*/


}
