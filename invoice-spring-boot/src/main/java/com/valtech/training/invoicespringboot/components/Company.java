package com.valtech.training.invoicespringboot.components;

public class Company {

	int companyId;
	String companyName;
	int addressId;

	public Company() {
	}

	public Company(String companyName, int addressId) {
		this.companyName = companyName;
		this.addressId = addressId;
	}

	public Company(int companyId, String companyName, int addressId) {
		this.companyId = companyId;
		this.companyName = companyName;
		this.addressId = addressId;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

}
