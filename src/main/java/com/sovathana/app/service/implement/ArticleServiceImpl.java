package com.sovathana.app.service.implement;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sovathana.app.model.Article;
import com.sovathana.app.repository.ArticleRepository;
import com.sovathana.app.service.ArticleService;
import com.sovathana.app.util.filter.ArticleFilter;
import com.sovathana.app.util.pagination.Paging;

@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRepository repo;

	@Override
	public ArrayList<Article> findAll(ArticleFilter filter, Paging paging) {
		return repo.findAll(filter, paging);
	}

	@Override
	public Article findOne(int id) {
		return repo.findOne(id);
	}

	@Override
	public boolean remove(int id) {
		return repo.remove(id);
	}

	@Override
	public boolean save(Article article) {
		return repo.save(article);
	}

	@Override
	public boolean update(Article article) {
		return repo.update(article);
	}
}
