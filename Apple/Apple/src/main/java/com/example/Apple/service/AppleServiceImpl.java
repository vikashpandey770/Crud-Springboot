package com.example.Apple.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Apple.entity.Apple;
import com.example.Apple.repository.AppleRepository;

@Service
public class AppleServiceImpl implements AppleService {

	@Autowired
	AppleRepository appleRepository;
	
	public Apple saveApple(Apple apple) {
		return appleRepository.save(apple);
	}
	
	public List<Apple>fetchAllApple(){
		return appleRepository.findAll();
	}
	public Apple getById(Long id) {
		Optional<Apple>apple=appleRepository.findById(id);
		if(apple.isPresent()) {
			return apple.get();
		}
		return null;
	}
	public Apple updateById(Long id, Apple apple) {
		Optional<Apple>apple1=appleRepository.findById(id);
		if(apple1.isPresent()) {
			Apple originalApple=apple1.get();
			if(Objects.nonNull(apple.getName())&& !"".equalsIgnoreCase(apple.getName())) {
				originalApple.setName(apple.getName());
			}
			if(Objects.nonNull(apple.getEmail())&& !"".equalsIgnoreCase(apple.getName())) {
				originalApple.setEmail(apple.getEmail());
			}
			if(Objects.nonNull(apple.getAddress())&& !"".equalsIgnoreCase(apple.getAddress())) {
				originalApple.setAddress(apple.getAddress());
			}
			return appleRepository.save(originalApple);
		}
		return null;
	}
	public String delete(Long id) {
		if(appleRepository.findById(id).isPresent()) {
			appleRepository.deleteById(id);
			return "apple data delete success";
		}
		return "no data found";
	}
	
}
