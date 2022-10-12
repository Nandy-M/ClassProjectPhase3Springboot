package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.model.applyAadhar;
import com.model.userRegister;

@Repository
public interface applyAadharRepo extends JpaRepository<applyAadhar, Integer> {

	public applyAadhar findById(userRegister id );

}