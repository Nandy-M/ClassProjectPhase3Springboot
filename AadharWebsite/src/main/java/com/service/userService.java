package com.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.model.applyAadhar;

import com.model.userRegister;
import com.repository.applyAadharRepo;

import com.repository.userRegisterRepo;

@Service
public class userService {

	@Autowired
	private userRegisterRepo urr;
	@Autowired
	private applyAadharRepo aar;
	@Autowired
	private userRegister u;

//	public String applyAadhar(userRegister u) {
//
//		if(urr.findByEmailid(u.getEmailid())==null)
//		{
//			urr.save(u);
//			return "Aadhar applied";
//		}
//		else
//		{
//			return "Aadhar already exists";
//		}
//	}
//
//	public String issueAadhar(applyAadhar aA) {
//		if(aar.findById(aA.getId())==null)
//		{
//			aar.save(aA);
//			
//		}
//		return "Aadhar issued";
//		
//	}

	public String userRegister(userRegister u) {
		if (urr.findByEmailid(u.getEmailid()) == null) {
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

	public userRegister updateAadhar(userRegister u) {
		
		userRegister existUser=urr.findById(u.getId()).orElse(null);
		if(existUser == null) {

			return urr.save(u);
		}
		else {
			urr.deleteById(existUser.getId());
			urr.save(u);
		}
     return u;
		
		
	}


}
