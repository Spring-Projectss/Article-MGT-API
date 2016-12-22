package com.sovathana.app.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.stereotype.Repository;

import com.sovathana.app.model.Article;
import com.sovathana.app.repository.sql.ArticleSQLProvider;
import com.sovathana.app.util.filter.ArticleFilter;
import com.sovathana.app.util.pagination.Paging;

@Repository
public interface ArticleRepository {
	
	@SelectProvider(method = "findAll", type = ArticleSQLProvider.class)
	public ArrayList<Article> findAll(@Param("filter") ArticleFilter filter, @Param("paging") Paging paging);
	
	@SelectProvider(method = "findOne", type = ArticleSQLProvider.class)
	public Article findOne(@Param("id") int id);
	
	@InsertProvider(method = "save", type = ArticleSQLProvider.class)
	public boolean save(@Param("art") Article article);
	
	@UpdateProvider(method = "update", type = ArticleSQLProvider.class)
	public boolean update(@Param("art") Article article);
	
	@DeleteProvider(method = "remove", type = ArticleSQLProvider.class)
	public boolean remove(@Param("id") int id);
}
