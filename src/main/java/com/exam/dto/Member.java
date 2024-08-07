package com.exam.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.Alias;

@Alias("Member")
public class Member {

	@NotBlank (message = "userid 필드는 필수 입력")
	String userid;
	
	@Size(min = 4, max = 6 ,message = "password 4~6 크기 입력")
	String password;
	
	@NotBlank (message = "username 필드는 필수 입력")
	String username;
	String role;
	
	public Member() {}

	public Member(String userid, String password, String username, String role) {
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.role = role;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Member [userid=" + userid + ", password=" + password + ", username=" + username + ", role=" + role
				+ "]";
	}

}
