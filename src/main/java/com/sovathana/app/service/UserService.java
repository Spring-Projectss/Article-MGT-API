package com.sovathana.app.service;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.sovathana.app.model.User;
import com.sovathana.app.model.form.UserForm;
import com.sovathana.app.model.form.UserUpdateForm;

public interface UserService {
	
	public ArrayList<User> findAll();
	
	public User findOne(@Param("id") int id);
	
	public User findByEmail(@Param("email") String email);
	
	public boolean insert(@Param("user") UserForm user);
	
	public boolean update(@Param("user") UserUpdateForm user);
	
	public boolean remove(@Param("id") int id);
}
