package com.example.CrudOne.service;

import java.util.List;

import com.example.CrudOne.entity.User;

public interface UserService {

	
	User saveUser(User user);
	List<User>fetchAllUser();
	User getById(Long id);
	User updateById(Long id , User user);
	String delete(Long id);
}
