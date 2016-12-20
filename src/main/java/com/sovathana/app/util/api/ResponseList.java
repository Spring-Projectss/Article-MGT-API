package com.sovathana.app.util.api;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sovathana.app.util.pagination.Paging;

public class ResponseList<T> extends Response {

	@JsonProperty("DATA")
	public List<T> data;

	@JsonProperty("PAGING")
	public Paging paging;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
