package com.demo.jobinfo;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Page;

@SuppressWarnings("serial")
public class Admin extends Model<Admin> {
	public static final Admin dao = new Admin();
	
	public Page<Admin> paginate(int pageNumber, int pageSize) {
		return paginate(pageNumber, pageSize, "select *", "from admin_zh order by id asc");
	}
	
	
	
}


