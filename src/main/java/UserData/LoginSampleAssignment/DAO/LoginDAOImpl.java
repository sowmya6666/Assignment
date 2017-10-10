package UserData.LoginSampleAssignment.DAO;
import java.util.List;

import javax.annotation.Resource;
import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{
     
			 
       @Resource(name="sessionFactory")
       protected SessionFactory sessionFactory;

       public void setSessionFactory(SessionFactory sessionFactory) {
              this.sessionFactory = sessionFactory;
       }
      
       protected Session getSession(){
              return sessionFactory.openSession();
       }

       public boolean checkLogin(String userName, String userPassword){
			
			Session session = sessionFactory.openSession();
			boolean userFound = false;
			
			String SQL_QUERY =" from User as o where o.username=? and o.password=?";
			org.hibernate.Query query = session.createQuery(SQL_QUERY);
			query.setParameter(0,userName);
			query.setParameter(1,userPassword);
			List list = query.list();

			if ((list != null) && (list.size() > 0)) {
				userFound= true;
			}

			session.close();
			return userFound;              
       }
}