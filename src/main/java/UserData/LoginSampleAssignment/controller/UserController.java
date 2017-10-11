package UserData.LoginSampleAssignment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import UserData.LoginSampleAssignment.form.LoginForm;
import UserData.LoginSampleAssignment.service.LoginService;

@Controller
@RequestMapping("loginform")
public class UserController {

	@Autowired
	public LoginService loginService;

	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model) {
		LoginForm loginForm = new LoginForm();
		model.put("loginForm", loginForm);
		return "loginform";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processForm(@Validated LoginForm loginForm, BindingResult result,Map model) {

		
		if (result.hasErrors()) {
			return "loginform";
		}
		
		
//		String userName = "UserName";
//		String password = "password";
//		loginForm = (LoginForm) model.get("loginForm");
//		if (!loginForm.getUserName().equals(userName)
//				|| !loginForm.getPassword().equals(password)) {
//			return "loginform";
//		}
//		return "loginsuccess";
		
		boolean userExists = loginService.checkLogin(loginForm.getUserName(),
                loginForm.getPassword());
		if(userExists){
			model.put("loginForm", loginForm);
			return "loginsuccess";
		}else{
			return "loginErrorForm";
		}

	}

}