package com.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="applyaadhar")
public class applyAadhar  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tableid;
    private String passportid;
    private String issuedate;
    @ManyToOne
	@JoinColumn(referencedColumnName = "id")
	private userRegister id;
	public int getTableid() {
		return tableid;
	}
	public void setTableid(int tableid) {
		this.tableid = tableid;
	}
	public String getPassportid() {
		return passportid;
	}
	public void setPassportid(String passportid) {
		this.passportid = passportid;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	
	public userRegister getId() {
		return id;
	}
	public void setId(userRegister id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "applyAadhar [tableid=" + tableid + ", passportid=" + passportid + ", issuedate=" + issuedate + ", id="
				+ id + "]";
	}
	
	
	
	
	
	
	


}
