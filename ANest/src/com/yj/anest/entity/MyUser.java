package com.yj.anest.entity;

import cn.bmob.v3.BmobUser;

public class MyUser extends BmobUser{
	/**
	 * f)sex
	   g)age
	   city
	 */
	private String nickname;
	private String sex;
	private String age;
	private String city;
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public MyUser(String nickname, String sex, String age, String city) {
		super();
		this.nickname = nickname;
		this.sex = sex;
		this.age = age;
		this.city = city;
	}
	public MyUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
