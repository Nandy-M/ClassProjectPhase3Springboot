package com.controller;

import org.springframework.beans.factory.annotation.Autowired;



import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.model.applyAadhar;

import com.model.userRegister;
import com.repository.userRegisterRepo;
import com.service.adminService;
import com.service.userService;


//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Aadhar")
public class mainController {
	
	@Autowired
	userService us;
	@Autowired
	adminService as;
	@Autowired
	userRegisterRepo urr;
	@PostMapping(value="userRegister", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String userRegiter(@RequestBody userRegister u)
	{
		return us.userRegister(u);
	}
	
	@PostMapping(value="userLogin", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String  userLogin(@RequestBody userRegister u)
	{
			return us.userLogin(u.getEmailid(),u.getPhno());
	}
	
//	@PutMapping(value="updateAadhar",consumes = MediaType.APPLICATION_JSON_VALUE)
//	public userRegister update(@RequestBody userRegister u) {
//		
//		return us.updateAadhar(u);
//	}
//	
	@PutMapping(value="updateAadhar",consumes = MediaType.APPLICATION_JSON_VALUE)
	public userRegister update(@RequestBody userRegister u) {
		return urr.save(u);
	}

	
	@DeleteMapping(value="deleteAadhar/{id}")
	public void delete(@PathVariable("id") Integer id) {
		urr.deleteById(id);
	}
	
	@GetMapping
	public Iterable<userRegister> getUser() {
		//it takes time to show the data.
//		try {
//			Thread.sleep(30000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		return urr.findAll();
	}
//	@PostMapping(value="applyAadhar",consumes = MediaType.APPLICATION_JSON_VALUE)
//	public String applyAadhar(@RequestBody user u)
//	{
//		return us.applyAadhar(u);
//		
//	}
//	@PostMapping(value="issueAadhar",consumes = MediaType.APPLICATION_JSON_VALUE)
//	public String issueAadhar(@RequestBody applyAadhar aA)
//	{
//		return us.issueAadhar(aA);
//	}
//	
	

    
}
