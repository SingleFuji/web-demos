package com.jo.po;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.google.gson.annotations.SerializedName;

/**
 * 用户信息
 * 
 * @author mango_jo
 *
 */
public class User implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 639706344679343116L;

	private String id;
	
	private String name;
	
	private String sex;
	
	private int age;
	
	private String email;
	
	private String address;
	
	private String birthday;
	
	/**
	 * 
	 */
	private List<App> appList; 
	
	@SerializedName(value="passportNo", alternate={"passport_no"})
	private String passportNo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPassportNo() {
		return passportNo;
	}

	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	
	public List<App> getAppList() {
		return appList;
	}

	public void setAppList(List<App> appList) {
		this.appList = appList;
	}

	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
}
