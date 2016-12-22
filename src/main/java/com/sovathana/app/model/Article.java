package com.sovathana.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Article {
	@JsonProperty("ID")
	private int id;
	@JsonProperty("TITLE")
	private String title;
	@JsonProperty("DESCRIPTION")
	private String description;
	@JsonProperty("IMAGE_URL")
	private String imageUrl;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", imageUrl=" + imageUrl
				+ ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getDescription()=" + getDescription()
				+ ", getImageUrl()=" + getImageUrl() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}	
}
