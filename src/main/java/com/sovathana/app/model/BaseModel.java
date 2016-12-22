package com.sovathana.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseModel {
	@JsonProperty("ID")
	int id;
	@JsonProperty("NAME")
	String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "BaseModel [id=" + id + ", name=" + name + "]";
	}
}
