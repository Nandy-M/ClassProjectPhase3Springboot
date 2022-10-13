package com.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="userregister")
public class userRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String dob;
	private String address;
	private String emailid;
	private String status;
	private String phno;
	private String gender;
	private String aadhaarNum;
	private Boolean newCardRequest;
	private Boolean duplicateCardRequest;
	
	public String getAadhaarNum() {
		return aadhaarNum;
	}
	public void setAadhaarNum(String aadhaarNum) {
		this.aadhaarNum = aadhaarNum;
	}
	public Boolean getNewCardRequest() {
		return newCardRequest;
	}
	public void setNewCardRequest(Boolean newCardRequest) {
		this.newCardRequest = newCardRequest;
	}
	public Boolean getDuplicateCardRequest() {
		return duplicateCardRequest;
	}
	public void setDuplicateCardRequest(Boolean duplicateCardRequest) {
		this.duplicateCardRequest = duplicateCardRequest;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "userRegister [id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + ", emailid="
				+ emailid + ", phno=" + phno + ", gender=" + gender + ", aadhaarNum=" + aadhaarNum + ", newCardRequest="
				+ newCardRequest + ", duplicateCardRequest=" + duplicateCardRequest + ", status=" + status + "]";
	}
	
	
	
	
	
	
	

}
