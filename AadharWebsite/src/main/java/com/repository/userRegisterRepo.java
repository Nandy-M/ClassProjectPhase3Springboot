package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.model.userRegister;

@Repository
public interface userRegisterRepo extends JpaRepository<userRegister, Integer> {

	public userRegister findByEmailid(String emailid);
	




}
