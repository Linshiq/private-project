package com.lsq.db.model;

import java.util.Date;

public class User {
	private String id;

	private String password;

	private String name;

	private String email;

	private String telephone;

	private String qq;

	private String sex;

	private String headPortrait;

	private Integer levelInfo;

	private Date signInTime;

	private Date updateOutTime;

	private Date creatTime;

	private Date updateTime;

	private String loginStatus;

	/**
	 * @param user
	 */
/*	public User(User user) {
		this.name = user.getName();
		this.password = user.getPassword();
		this.id = user.getId();

	}*/

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public Date getSignInTime() {
		return signInTime;
	}

	public void setSignInTime(Date signInTime) {
		this.signInTime = signInTime;
	}

	public Date getUpdateOutTime() {
		return updateOutTime;
	}

	public void setUpdateOutTime(Date updateOutTime) {
		this.updateOutTime = updateOutTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone == null ? null : telephone.trim();
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq == null ? null : qq.trim();
	}

	public Date getCreatTime() {
		return creatTime;
	}

	public void setCreatTime(Date creatTime) {
		this.creatTime = creatTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getHeadPortrait() {
		return headPortrait;
	}

	public void setHeadPortrait(String headPortrait) {
		this.headPortrait = headPortrait == null ? null : headPortrait.trim();
	}

	public Integer getLevelInfo() {
		return levelInfo;
	}

	public void setLevelInfo(Integer levelInfo) {
		this.levelInfo = levelInfo;
	}

}