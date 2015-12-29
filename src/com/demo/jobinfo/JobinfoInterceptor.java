package com.demo.jobinfo;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class JobinfoInterceptor implements Interceptor {

	public void intercept(Invocation inv) {
		 Controller controller = inv.getController();
		    Admin loginAdmin = controller.getSessionAttr("loginAdmin");
		    if (loginAdmin != null)
		    	inv.invoke();
		    else
		      controller.redirect("/admin/login.html");
	}

}
