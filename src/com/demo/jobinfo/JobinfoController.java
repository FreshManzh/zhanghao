package com.demo.jobinfo;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import com.jfinal.aop.Before;
import com.jfinal.core.Controller;

public class JobinfoController extends Controller {

	// ���÷�����ҳ
	public void index() {
		setAttr("jobInfoPage", Jobinfo.me.paginate(getParaToInt(0, 1), 10));
		render("../admin/job_info.html");
	}

	// �û�ע��
	public void register() {
		getModel(Admin.class).save();
		redirect("/");
	}
	
	public void toReg(){
		render("../admin/register.html");
	}

	// �û���¼
	@Before(LoginValidator.class)
	public void login() {
		String name = getPara("name");
		String password = getPara("password");
		Admin adminInDb = Admin.dao.findFirst("select * from admin_zh a where a.name=? and a.password=? ", name,
				password);
		if (adminInDb != null) {
			if (password.equals(adminInDb.getStr("password"))) {

				setSessionAttr("loginAdmin", adminInDb);
				
				redirect("/jobinfo");
			} else {
				
				redirect("/");
			}
		} else {
			
			redirect("/");
		}
		
	}

	// �����Ϣ
	public void job_info_insert() {
		
	}
	
	// ������Ϣ
	public void save() {
		getModel(Jobinfo.class).save();
		redirect("/jobinfo");
	}

	// �޸���Ϣ
	public void edit() {
		setAttr("jobinfo", Jobinfo.me.findById(getParaToInt()));
	}

	@Before(JobInfoValidator.class)
	public void update() {
		getModel(Jobinfo.class).update();
		redirect("/jobinfo");
	}

	// ɾ����Ϣ
	public void delete() {
		Jobinfo.me.deleteById(getParaToInt());
		redirect("/jobinfo");
	}
	
	//�鿴����
	public void detail(){
		setAttr("jobinfo", Jobinfo.me.findById(getParaToInt()));
		render("../admin/job_info_details.html");
	}
	

//	 ��Ϣ������ʾ
//	 public void ajaxDone(int statusCode, String message) {
//	 setAttr("statusCode", statusCode);
//	 setAttr("message", message);
//	 }
//	 public void ajaxDoneError(String message) {
//	 ajaxDone(300, message);
//	 }

}
