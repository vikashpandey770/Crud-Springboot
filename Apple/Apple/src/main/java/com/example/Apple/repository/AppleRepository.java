package com.example.Apple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Apple.entity.Apple;

public interface AppleRepository extends JpaRepository<Apple,Long> {

	
}
