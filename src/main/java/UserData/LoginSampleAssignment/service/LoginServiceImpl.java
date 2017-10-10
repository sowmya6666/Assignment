package UserData.LoginSampleAssignment.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import UserData.LoginSampleAssignment.DAO.LoginDAO;
import UserData.LoginSampleAssignment.service.*;




@Service("loginService")
public class LoginServiceImpl implements LoginService {

	 @Autowired
	 private LoginDAO loginDAO;

	   public void setLoginDAO(LoginDAO loginDAO) {
              this.loginDAO = loginDAO;
       }
      
       public boolean checkLogin(String userName, String userPassword){
              System.out.println("In Service class...Check Login");
              return loginDAO.checkLogin(userName, userPassword);
       }
}