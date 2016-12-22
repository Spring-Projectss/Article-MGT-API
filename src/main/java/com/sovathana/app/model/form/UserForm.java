package com.sovathana.app.model.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserForm {
	@JsonProperty("NAME")
	private String name;
	@JsonProperty("PASSWORD")
	private String password;
	@JsonProperty("EMAIL")
	private String email;
	@JsonProperty("ROLE_ID")
	private int role_id;
	
	public UserForm(){}
	
	public UserForm(String name, String password, String email, int role_id) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.role_id = role_id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getRole_id() {
		return role_id;
	}
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "UserForm [name=" + name + ", password=" + password + ", email=" + email + ", role_id=" + role_id + "]";
	}
}


