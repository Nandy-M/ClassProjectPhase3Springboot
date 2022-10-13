package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.model.userRegister;


import com.repository.userRegisterRepo;

@Service
public class userService {

	@Autowired
	private userRegisterRepo urr;
	
	@Autowired
	private userRegister u;

	public String userRegister(userRegister u) {
		if (urr.findByEmailid(u.getEmailid()) == null) {
			u.setStatus("Alive");
			urr.save(u);
			return "User registered";
			
		} else {
			return "User already exists";
		}
	}

	public String userLogin(String emailid, String phno) {
		u = urr.findByEmailid(emailid);
		if (u != null) {

			if (u.getEmailid().equals(emailid) && u.getPhno().equals(phno)) {
				return "login sucessfull";
			} else {
				return "invalid credentials";
			}

		} else {
			return "User not found";
		}

	}

}
