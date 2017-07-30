package actions;

import java.lang.annotation.Retention;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;

public class LoginAction extends ActionSupport implements SessionAware {
	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private Map<String,Object> session;
	
	
	public String login() {
		if (this.userName.equals("admin") && this.password.equals("admin"))
			session.put("user", this.userName);
		else
			addActionError("El usuario o la contraseña no son correctos");
		return SUCCESS;
	}
	
	public String logout() {
		session.remove("user");
		return SUCCESS;
	}

	public String getUserName() {
		return userName;
	}
	
	@RequiredStringValidator(message = "El nombre de usuario es un campo obligatorio.")
    @StringLengthFieldValidator(minLength="4", maxLength="10", message="El nombre debe tener entre 4 y 10 caracteres")
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	@RequiredStringValidator(message = "La contraseña es un campo obligatorio.")
    @StringLengthFieldValidator(minLength="4", maxLength="10", message="La contraseña debe tener entre 4 y 10 caracteres")
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
