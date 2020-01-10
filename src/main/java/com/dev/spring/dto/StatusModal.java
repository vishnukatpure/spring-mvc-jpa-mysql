package com.dev.spring.dto;

import java.io.Serializable;

public class StatusModal implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long status;
	private String message;
	private Object object;
	
	
	
	public long getStatus() {
		return status;
	}
	public void setStatus(long status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getObject() {
		return object;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	

}
