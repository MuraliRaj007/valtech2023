package com.valtech.training.invoicespringboot.components;

public class Customer {
	int customerId;
	String customerName;
	long phoneNo;
	int adderessId;

	public Customer() {
	}

	public Customer(String customerName, long phoneNo, int adderessId) {
		this.customerName = customerName;
		this.phoneNo = phoneNo;
		this.adderessId = adderessId;
	}

	public Customer(int customerId, String customerName, long phoneNo, int adderessId) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.phoneNo = phoneNo;
		this.adderessId = adderessId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public int getAdderessId() {
		return adderessId;
	}

	public void setAdderessId(int adderessId) {
		this.adderessId = adderessId;
	}

	

}
