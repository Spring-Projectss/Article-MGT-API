package com.sovathana.app.model;

public class User extends BaseModel{
	
	private String password;
	private String email;
	private Role role;
	
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
