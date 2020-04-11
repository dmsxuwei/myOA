package com.dms.oa.dao;




import com.dms.oa.po.User;




/**
 * 
 * @author Administrator
 *
 */

public interface UserDao {
	
	User selectByPrimaryKey(Integer userid);
	
}
