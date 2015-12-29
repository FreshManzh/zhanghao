package com.demo.common;

import com.demo.index.IndexController;
import com.demo.jobinfo.Admin;
import com.demo.jobinfo.Jobinfo;
import com.demo.jobinfo.JobinfoController;
import com.demo.jobinfo.JobinfoInterceptor;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;

public class DemoConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {
		PropKit.use("a_little_config.txt");
		me.setDevMode(PropKit.getBoolean("devMode", true));

	}

	@Override
	public void configRoute(Routes me) {
		me.add("/", IndexController.class); 
		me.add("/jobinfo", JobinfoController.class, "/admin");// ����������Ϊ��Controller����ͼ���·��
	}

	@Override
	public void configPlugin(Plugins me) {
		// ����C3p0���ݿ����ӳز��
		C3p0Plugin c3p0Plugin = new C3p0Plugin(PropKit.get("jdbcUrl"), PropKit.get("user"),
				PropKit.get("password").trim());
		me.add(c3p0Plugin);

		// ����ActiveRecord���
		ActiveRecordPlugin arp = new ActiveRecordPlugin(c3p0Plugin);
		me.add(arp);
		arp.addMapping("job_info_zhanghao", Jobinfo.class); // ӳ��job_info_zhanghao �� Jobinfoģ��
		arp.addMapping("Admin_zh", Admin.class);
		
	}
	
	@Override
	public void configInterceptor(Interceptors me) {
//		 me.add(new JobinfoInterceptor());

	}

	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub

	}

	
	public static void main(String[] args) {
		JFinal.start("WebRoot", 80, "/", 5);
	}
}
