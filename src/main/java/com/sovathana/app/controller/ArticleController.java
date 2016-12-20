package com.sovathana.app.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sovathana.app.model.Article;
import com.sovathana.app.service.ArticleService;
import com.sovathana.app.util.api.ResponseCode;
import com.sovathana.app.util.api.ResponseList;
import com.sovathana.app.util.filter.ArticleFilter;
import com.sovathana.app.util.pagination.Paging;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api")
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	@ApiImplicitParams({
		// Filter Param
		@ApiImplicitParam(name="title", dataType="string", paramType="query", defaultValue="", value="Filter by article's title." ),
		// Page Param
		@ApiImplicitParam(name="page", dataType="integer", paramType="query", defaultValue="1", value="Page"),
		@ApiImplicitParam(name = "limit", dataType = "integer", paramType = "query", defaultValue = "10", value = "Limit")
	})
	@ApiOperation("Get All Articles")
	@RequestMapping(value="/article", method=RequestMethod.GET)
	public ResponseList<Article> findAll(@ApiIgnore ArticleFilter filter, @ApiIgnore Paging paging){
		ResponseList<Article> response = new ResponseList<>();
		
		ArrayList<Article> list = articleService.findAll(filter, paging);
		// Set Message
		if (list.isEmpty())
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
		else
			response.setCode(ResponseCode.RECORD_FOUND);
		
		// Set Data
		response.setData(list);
		response.setPaging(paging);
		return response;
	}
	
}
