package com.sovathana.app.model;

public class Article {
	private int id;
	private String title;
	private String description;
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
