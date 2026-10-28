package com.example.CrudOne.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CrudOne.entity.User;
import com.example.CrudOne.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
@Autowired
UserRepository userRepository;

public User saveUser(User user) {
	return userRepository.save(user);
}
public List<User>fetchAllUser(){
	return userRepository.findAll();
}
public User getById(Long id) {
	Optional<User> user=userRepository.findById(id);
	if(user.isPresent()) {
		return user.get();
	}
	return null;
	
}

public User updateById(Long id,User user) {
	Optional<User> user1=userRepository.findById(id);
	if(user1.isPresent()) {
		User originalUser=user1.get();
		if(Objects.nonNull(user.getName())&& !"".equalsIgnoreCase(user.getName())) {
			originalUser.setName(user.getName());
		}
		if(Objects.nonNull(user.getEmail())&& !"".equalsIgnoreCase(user.getEmail())) {
			originalUser.setEmail(user.getEmail());
		}
		return userRepository.save(originalUser);
	}
	return null;
}


public String delete(Long id) {
	if(userRepository.findById(id).isPresent()) {
		userRepository.deleteById(id);
		return "user delete successfully";
	}
	return "no user in database";
}	
}
