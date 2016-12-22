package com.sovathana.app.service.implement;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sovathana.app.model.User;
import com.sovathana.app.model.form.UserForm;
import com.sovathana.app.model.form.UserUpdateForm;
import com.sovathana.app.repository.UserRepository;
import com.sovathana.app.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	@Override
	public ArrayList<User> findAll() {
		return repo.findAll();
	}

	@Override
	public User findOne(int id) {
		return repo.findOne(id);
	}

	@Override
	public User findByEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public boolean insert(UserForm user) {
		return repo.insert(user);
	}

	@Override
	public boolean update(UserUpdateForm user) {
		return repo.update(user);
	}

	@Override
	public boolean remove(int id) {
		return repo.remove(id);
	}
	
}
