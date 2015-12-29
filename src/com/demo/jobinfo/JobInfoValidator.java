package com.demo.jobinfo;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

/**
 * BlogValidator.
 */
public class JobInfoValidator extends Validator {

	protected void validate(Controller controller) {
		validateRequired("jobinfo.department", "department", "不能为空！");
		validateRequired("jobinfo.office", "office", "不能为空！");
		validateRequired("jobinfo.needCount", "needCount", "不能为空！");
	}

	protected void handleError(Controller controller) {
		controller.keepModel(Jobinfo.class);

		String actionKey = getActionKey();
		if (actionKey.equals("/jobinfo/save"))
			controller.render("../admin/job_info.html");
		else if (actionKey.equals("/jobinfo/update"))
			controller.render("../admin/job_info_update.html");
	}
}
