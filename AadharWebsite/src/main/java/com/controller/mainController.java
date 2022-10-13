package com.controller;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.userRegister;
import com.repository.userRegisterRepo;
import com.service.adminService;
import com.service.userService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("Aadhar")
public class mainController {

	@Autowired
	userService us;
	@Autowired
	adminService as;
	@Autowired
	userRegisterRepo urr;

	@PostMapping(value = "/user/userRegister", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String userRegiter(@RequestBody userRegister u) {
		return us.userRegister(u);
	}

	@PostMapping(value = "/user/userLogin", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String userLogin(@RequestBody userRegister u) {
		return us.userLogin(u.getEmailid(), u.getPhno());
	}

	@PutMapping(value = "/user/updateAadhar", consumes = MediaType.APPLICATION_JSON_VALUE)
	public userRegister update(@RequestBody userRegister u) {
		return urr.save(u);
	}
	
	// User Apply New Card
	@PostMapping(value = "/user/newCard/{id}")
	public ResponseEntity<userRegister> newCard(@PathVariable("id") Integer id, @RequestBody userRegister u) {
		Optional<userRegister> optProduct = urr.findById(id);

		userRegister user = new userRegister();
		user = optProduct.get();

		user.setNewCardRequest(true);
		final userRegister updatedUser = urr.save(user);
		return ResponseEntity.ok(updatedUser);

	}

	// User Apply Duplicate Card
	@PostMapping(value = "/user/dupCard/{id}")
	public ResponseEntity<userRegister> dupCard(@PathVariable("id") Integer id, @RequestBody userRegister u) {
		Optional<userRegister> optProduct = urr.findById(id);

		userRegister user = new userRegister();
		user = optProduct.get();

		user.setDuplicateCardRequest(true);
		final userRegister updatedUser = urr.save(user);
		return ResponseEntity.ok(updatedUser);

	}
	

	// User Delete
	@DeleteMapping("/admin/deleteUser/{id}")
	public String deleteUser(@PathVariable("id") Integer id) {
		Optional<userRegister> optProduct = urr.findById(id);
		userRegister u = new userRegister();
		u = optProduct.get();
		if (u.getStatus() == "Alive") {
			return "Cannot delete Aadhaar.";
		} else {
			urr.deleteById(id);
			return "Aadhaar deleted.";
		}
	}

	@GetMapping("/admin/listUsers")
	public Iterable<userRegister> list() {
		return urr.findAll();
	}

	@PostMapping(value = "/admin/newCard/{id}")
	public ResponseEntity<userRegister> issueNewCard(@PathVariable("id") Integer id, @RequestBody userRegister u) {
		Optional<userRegister> optProduct = urr.findById(id);

		userRegister user = new userRegister();
		user = optProduct.get();

		Random generator = new Random(System.currentTimeMillis());
		Long num = generator.nextLong() % 1000000000;
		String aadhNum = String.valueOf(num);

		if ((user.getNewCardRequest() == true)) {
			user.setNewCardRequest(null);
			user.setAadhaarNum(aadhNum);
		}
		final userRegister updatedUser = urr.save(user);
		return ResponseEntity.ok(updatedUser);

	}

	// Admin Issue Duplicate Card
	@PostMapping(value = "/admin/dupCard/{id}")
	public ResponseEntity<userRegister> issueDupCard(@PathVariable("id") Integer id, @RequestBody userRegister u) {
		Optional<userRegister> optProduct = urr.findById(id);

		userRegister user = new userRegister();
		user = optProduct.get();

		if ((user.getDuplicateCardRequest() == true)) {
			user.setDuplicateCardRequest(null);
		}
		final userRegister updatedUser = urr.save(user);
		return ResponseEntity.ok(updatedUser);

	}

}
