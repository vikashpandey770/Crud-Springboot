package com.example.Apple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Apple.entity.Apple;
import com.example.Apple.service.AppleService;

@RestController
public class AppleController {

	@Autowired
	AppleService appleService;
	
	@PostMapping("/apple")
	public Apple saveApple(@RequestBody Apple apple) {
		return appleService.saveApple(apple);
	}
	@GetMapping("/apple")
	public List<Apple>fetchAllApple(){
		return appleService.fetchAllApple();
	}
	@GetMapping("/apple/{id}")
	public Apple getById(@PathVariable("id") Long id) {
		return appleService.getById(id);
	}
	
	@PutMapping("/apple/{id}")
	public Apple updateById(@PathVariable("id")Long id, @RequestBody Apple apple) {
		return appleService.updateById(id, apple);
	}
	
	@DeleteMapping("/apple/{id}")
	public String delete(@PathVariable("id") Long id) {
		return appleService.delete(id);
	}
	
}
