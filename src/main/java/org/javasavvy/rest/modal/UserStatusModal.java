package org.javasavvy.rest.modal;

public class UserStatusModal {
	
	private int status;
	private String message;
	private UserModal user;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public UserModal getUser() {
		return user;
	}
	public void setUser(UserModal user) {
		this.user = user;
	}
	
	

}
