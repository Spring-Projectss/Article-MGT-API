package com.sovathana.app.util.filter;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ArticleFilter {
	@JsonProperty("TITLE")
	private String title;

	public ArticleFilter(){
		title = "";
	}
	
	public ArticleFilter(String title){
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return "ArticleFilter [title=" + title + "]";
	}
}
