package actions;

//import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private Map<String,Object> session;
	
	public String login() {
		if (this.userName.equals("admin") && this.password.equals("admin"))
		{
			session.put("user", this.userName);
			return "SUCCESS";
		}
		addActionError("El usuario o la contraseña no son correctos");
		return"ERROR";
	}
	
	public String logout() {
		session.remove("user");
		return "SUCCESS";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
