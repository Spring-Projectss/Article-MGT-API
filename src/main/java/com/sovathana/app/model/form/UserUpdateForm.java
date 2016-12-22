package com.sovathana.app.model.form;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserUpdateForm extends UserForm{
	@JsonProperty("ID")
	int id;
	
	public UserUpdateForm(){}
	
	public UserUpdateForm(int id) {
		super();
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}