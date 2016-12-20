package com.sovathana.app.service;

import java.util.ArrayList;
import com.sovathana.app.model.Article;
import com.sovathana.app.util.filter.ArticleFilter;
import com.sovathana.app.util.pagination.Paging;

public interface ArticleService {
	
	/***
	 * Get all Article with filtering and pagination.
	 * Return ArrayList of Article
	 * 
	 * @param filter
	 * @param paging
	 * @return
	 */
	public ArrayList<Article> findAll(ArticleFilter filter, Paging paging);
	
	/***
	 * Get only one article filtering by user id
	 * Return article object
	 * 
	 * @param id
	 * @return
	 */
	public Article findOne(int id);
	
	/***
	 * Remove user by user id
	 * Return boolean value. if true->success, else failed
	 * 
	 * @param id
	 * @return
	 */
	public boolean remove(int id);
	

	/***
	 * Save article
	 * Return boolean value. if true->success, else failed
	 * 
	 * @param article
	 * @return
	 */
	public boolean save(Article article);
	

	/***
	 * Update article
	 * Return boolean value. if true->success, else failed
	 * 
	 * @param article
	 * @return
	 */
	public boolean update(Article article);
	
}
