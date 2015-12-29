package com.demo.jobinfo;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class LoginValidator extends Validator {

//	private static final String msg = "message";
	
	@Override
	protected void validate(Controller c) {
		setShortCircuit(true);
		validateRequired("name", "namemsg", " �������û���!");
		validateRequired("password", "pwdmsg", " ����������!");
		
	}

	@Override
	protected void handleError(Controller c) {
		c.keepPara(Admin.class);
		c.render("/admin/login.html");
	}

}
