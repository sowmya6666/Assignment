package UserData.LoginSampleAssignment.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;
import java.sql.Timestamp;


@Entity
@Table(name = "user")
@SuppressWarnings("serial")
public class User implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id", length = 11 )
	private Long id;
	
	@Column(name = "username")
	String userName;

	@Column(name = "password")
	String userPassword;


	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	} 



	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
