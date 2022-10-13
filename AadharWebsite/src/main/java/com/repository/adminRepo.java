package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.admin;
import com.model.userRegister;

@Repository
public interface adminRepo extends JpaRepository<admin, Integer> {
	userRegister save(userRegister u);

}