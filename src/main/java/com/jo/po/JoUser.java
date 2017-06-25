package com.jo.po;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 登录用户名密码
 * 
 * @author mango_jo
 *
 */
public class JoUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6012667090451335704L;

	private String id;
	
	private String username;
	
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
