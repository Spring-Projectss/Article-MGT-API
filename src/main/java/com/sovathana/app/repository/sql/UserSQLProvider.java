package com.sovathana.app.repository.sql;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import com.sovathana.app.model.form.UserForm;
import com.sovathana.app.model.form.UserUpdateForm;

public class UserSQLProvider {
	
	public String findAll(){
		return new SQL(){{
			SELECT("u.id, u.name, u.email, r.id as role_id, r.name as role_name").
			FROM("users u ").
			INNER_JOIN("role r on r.id=u.role_id");
		}}.toString();
	}
	
	public String findOne(@Param("id") int id){
		return new SQL(){{
			SELECT("u.id, u.name, u.email, r.id as role_id, r.name as role_name").
			FROM("users u ").
			INNER_JOIN("role r on r.id=u.role_id").
			WHERE("u.id = #{id}");
		}}.toString();
	}
	
	public String findByEmail(@Param("email") String email){
		return new SQL(){{
			SELECT("u.id, u.name, u.email, r.id as role_id, r.name as role_name").
			FROM("users u ").
			INNER_JOIN("role r on r.id=u.role_id").
			WHERE("u.email = #{email}");
		}}.toString();
	}
	
	public String insert(@Param("user") UserForm user){
		return new SQL(){{
			INSERT_INTO("users").
			VALUES("name", "#{user.name}").
			VALUES("email", "#{user.email}").
			VALUES("password", "#{user.password}").
			VALUES("role_id", "#{user.role_id}");
		}}.toString();
	}
	
	public String update(@Param("user") UserUpdateForm user){
		return new SQL(){{
			UPDATE("users").
			SET("name=#{user.name}, email=#{user.email}, role_id=#{user.role_id}").
			WHERE("id=#{user.id}");
		}}.toString();
	}
	
	public String remove(@Param("id") int id){
		return new SQL(){{
			DELETE_FROM("users").WHERE("id=#{id}");
		}}.toString();
	}
	
}
