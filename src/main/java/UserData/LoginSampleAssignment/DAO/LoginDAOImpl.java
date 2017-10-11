package UserData.LoginSampleAssignment.DAO;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginDAOImpl implements LoginDAO{
     
	   @Autowired	 
       private SessionFactory sessionFactory;

       public boolean checkLogin(String username, String password){
			
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			System.out.println("user name"+username);
			System.out.println("password"+password);
			String SQL_QUERY ="select * from assignment.user where username=:username and password=:password";
			org.hibernate.Query query = session.createSQLQuery(SQL_QUERY);
			query.setString("username", username);
			query.setString("password", password);
			List list = query.list();
			if ((list != null) && (list.size() > 0)) {
				userFound= true;
			}
			session.close();
			return userFound;              
       }
}