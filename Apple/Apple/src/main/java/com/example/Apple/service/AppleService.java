package com.example.Apple.service;

import java.util.List;

import com.example.Apple.entity.Apple;

public interface AppleService {

	Apple saveApple(Apple apple);
	List<Apple>fetchAllApple();
	Apple getById(Long id);
	Apple updateById(Long id, Apple apple);
	String delete(Long id);
	
}
