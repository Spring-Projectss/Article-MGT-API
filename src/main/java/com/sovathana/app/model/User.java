package com.sovathana.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User extends BaseModel{
	
	@JsonProperty("PASSWORD")
	private String password;
	@JsonProperty("EMAIL")
	private String email;
	@JsonProperty("ROLE")
	private Role role;
	
	public User(){}
	
	public User(String password, String email, Role role) {
		super();
		this.password = password;
		this.email = email;
		this.role = role;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		return "User [password=" + password + ", email=" + email + ", role=" + role + "]";
	}
}
