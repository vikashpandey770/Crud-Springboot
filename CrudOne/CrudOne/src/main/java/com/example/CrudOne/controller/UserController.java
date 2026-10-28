package com.example.CrudOne.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudOne.entity.User;
import com.example.CrudOne.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@GetMapping("/user")
	public List<User> fetchAllUser(){
		return userService.fetchAllUser();
	}
	
	@GetMapping("/user/{id}")
	public User getById(@PathVariable("id")Long id) {
		return userService.getById(id);
	}
	@PutMapping("user/{id}")
	public User updateById(@PathVariable("id")Long id, @RequestBody User user) {
		
		return userService.updateById(id, user);
	}
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable ("id")Long id) {
		return userService.delete(id);
	}
	

	
}
