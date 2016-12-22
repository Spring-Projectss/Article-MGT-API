package com.sovathana.app.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.sovathana.app.model.User;
import com.sovathana.app.model.form.UserForm;
import com.sovathana.app.model.form.UserUpdateForm;
import com.sovathana.app.repository.sql.UserSQLProvider;

public interface UserRepository {
	
	@SelectProvider(method="findAll", type=UserSQLProvider.class)
	@Results({
		@Result(column="role_id", property="role.id"),
		@Result(column="role_name", property="role.name")
	})
	public ArrayList<User> findAll();
	
	@SelectProvider(method="findOne", type=UserSQLProvider.class)
	@Results({
		@Result(column="role_id", property="role.id"),
		@Result(column="role_name", property="role.name")
	})
	public User findOne(@Param("id") int id);
	
	@SelectProvider(method="findByEmail", type=UserSQLProvider.class)
	@Results({
		@Result(column="role_id", property="role.id"),
		@Result(column="role_name", property="role.name")
	})
	public User findByEmail(@Param("email") String email);
	
	@InsertProvider(method="insert", type=UserSQLProvider.class)
	public boolean insert(@Param("user") UserForm user);
	
	@UpdateProvider(method="update", type=UserSQLProvider.class)
	public boolean update(@Param("user") UserUpdateForm user);
	
	@DeleteProvider(method="remove", type=UserSQLProvider.class)
	public boolean remove(@Param("id") int id);
}
