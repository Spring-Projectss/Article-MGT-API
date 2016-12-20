package com.sovathana.app.repository.sql;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.sovathana.app.model.Article;
import com.sovathana.app.util.filter.ArticleFilter;
import com.sovathana.app.util.pagination.Paging;

public class ArticleSQLProvider {
	public String findAll(@Param("filter") ArticleFilter filter, @Param("paging") Paging paging){
		System.err.println(filter);
		System.err.println(paging);
		return new SQL(){{
			SELECT("id, title, description, image_url AS imageUrl ").
			FROM("article "
					+ "WHERE LOWER(title) LIKE '%' || LOWER(#{filter.title}) || '%' "
					+ "LIMIT #{paging.limit} "
					+ "OFFSET #{paging.offset}");
		}}.toString();
	}
	
	public String findOne(@Param("id") int id){
		return new SQL(){{
			SELECT("id, title, description, image_url AS imageUrl").
			FROM("article").
			WHERE("id = #{id}");
		}}.toString();
	}
	
	public String save(@Param("art") Article article){
		return new SQL(){{
			INSERT_INTO("article").
			VALUES("title", "#{art.title}").
			VALUES("description", "#{art.description}").
			VALUES("image_url", "art.imageUrl");
		}}.toString();
	}
	
	public String update(@Param("art") Article article){
		return new SQL(){{
			UPDATE("article").SET("title = #{art.title}, "
					+ "description = #{art.description}, "
					+ "image_url = #{art.imageUrl}").
			WHERE("id = #{art.id}");
		}}.toString();
	}
	
	public String remove(@Param("id") int id){
		return new SQL(){{
			DELETE_FROM("article").
			WHERE("id = #{id}");
		}}.toString();
	}
}
