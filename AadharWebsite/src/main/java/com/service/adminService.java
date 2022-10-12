package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.adminRepo;

@Service
public class adminService {
	
	@Autowired
   private adminRepo adminrepo;

}
