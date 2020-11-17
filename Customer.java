package com.cg.vegetable.mgmt.customer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int CustId;
@Column(nullable=false)
private String name;
@Column(nullable=false)
private long mobileno;
@Column(nullable=false)
private long address;
@Column(nullable=false)
private String emailid;
@Column(nullable=false)
private  String password;
@Column(nullable=false)
private String confirmpass;
public int getCustId() {
	return CustId;
}
public void setCustId(int custId) {
	CustId = custId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getMobileno() {
	return mobileno;
}
public void setMobileno(long mobileno) {
	this.mobileno = mobileno;
}
public long getAddress() {
	return address;
}
public void setAddress(long address) {
	this.address = address;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirmpass() {
	return confirmpass;
}
public void setConfirmpass(String confirmpass) {
	this.confirmpass = confirmpass;
}
@Override
public String toString() {
	return "Customer [CustId=" + CustId + ", name=" + name + ", mobileno=" + mobileno + ", address=" + address
			+ ", emailid=" + emailid + ", password=" + password + ", confirmpass=" + confirmpass + "]";
}
}
