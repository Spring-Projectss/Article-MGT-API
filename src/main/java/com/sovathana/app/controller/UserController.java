package com.sovathana.app.controller;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sovathana.app.model.User;
import com.sovathana.app.model.form.UserForm;
import com.sovathana.app.model.form.UserUpdateForm;
import com.sovathana.app.service.UserService;
import com.sovathana.app.util.api.Response;
import com.sovathana.app.util.api.ResponseCode;
import com.sovathana.app.util.api.ResponseList;
import com.sovathana.app.util.api.ResponseMessage;
import com.sovathana.app.util.api.ResponseRecord;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@ApiOperation("Find All Users")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseList<User> findAll(){
		ResponseList<User> response = new ResponseList<>();
		
		ArrayList<User> list = service.findAll();
		
		if (list.isEmpty()){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
			response.setMessage(ResponseMessage.RECORD_NOT_FOUND);
		}else{
			response.setCode(ResponseCode.RECORD_FOUND);
			response.setMessage(ResponseMessage.RECORD_NOT_FOUND);
		}
		
		response.setData(list);
		
		return response;
	}
	
	@ApiOperation("Find User by ID")
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseRecord<User> findOne(@PathVariable("id") int id){
		ResponseRecord<User> response = new ResponseRecord<>();
		
		User user = service.findOne(id);
		
		if (user == null){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
			response.setMessage(ResponseMessage.RECORD_NOT_FOUND);
		}else{
			response.setCode(ResponseCode.RECORD_FOUND);
			response.setMessage(ResponseMessage.RECORD_NOT_FOUND);
		}
		
		response.setData(user);
		
		return response;
	}
	
	@ApiOperation("Find User by Email")
	@ApiImplicitParams({
		@ApiImplicitParam(name="email", dataType="string", paramType="query", value="User's Email", required=true)
	})
	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseRecord<User> findByEmail(@ApiIgnore String email){
		ResponseRecord<User> response = new ResponseRecord<>();
		
		User user = service.findByEmail(email);
		System.err.println(email);
		if (user == null){
			response.setCode(ResponseCode.RECORD_NOT_FOUND);
			response.setMessage(ResponseMessage.RECORD_NOT_FOUND);
		}else{
			response.setCode(ResponseCode.RECORD_FOUND);
			response.setMessage(ResponseMessage.RECORD_NOT_FOUND);
		}
		
		response.setData(user);
		
		return response;
	}
	
	@ApiOperation("Add New User")
	@RequestMapping(method=RequestMethod.POST)
	public Response insert(@RequestBody UserForm user){
		Response response = new Response();
		
		if (service.insert(user)){
			response.setCode(ResponseCode.INSERT_SUCCESS);
			response.setMessage(ResponseMessage.INSERT_SUCCESS);
		}else{
			response.setCode(ResponseCode.INSERT_FAIL);
			response.setMessage(ResponseMessage.INSERT_FAIL);
		}
		
		return response;
	}
	
	@ApiOperation("Update User")
	@RequestMapping(method=RequestMethod.PUT)
	public Response update(@RequestBody UserUpdateForm user){
		Response response = new Response();
		
		if (service.update(user)){
			response.setCode(ResponseCode.UPDATE_SUCCESS);
			response.setMessage(ResponseMessage.UPDATE_SUCCESS);
		}else{
			response.setCode(ResponseCode.UPDATE_FAIL);
			response.setMessage(ResponseMessage.UPDATE_FAIL);
		}
		
		return response;
	}
	
	@ApiOperation("Delete user base on User's ID")
	@RequestMapping(method=RequestMethod.DELETE)
	public Response remove(@RequestParam("id") int id){
		Response response = new Response();
		
		if (service.remove(id)){
			response.setCode(ResponseCode.DELETE_SUCCESS);
			response.setMessage(ResponseMessage.DELETE_SUCCESS);
		}else{
			response.setCode(ResponseCode.DELETE_FAIL);
			response.setMessage(ResponseMessage.DELETE_FAIL);
		}
		
		return response;
	}
	
}
