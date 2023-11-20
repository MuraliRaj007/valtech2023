package com.valtech.training.invoicespringboot.components;

public class Address {
int id;
String street;
String city;
int zipcode;




public Address() {
}



public Address(int id, String street, String city, int zipcode) {
	this.id = id;
	this.street = street;
	this.city = city;
	this.zipcode = zipcode;
}



public Address(String street, String city, int zipcode) {
	this.street = street;
	this.city = city;
	this.zipcode = zipcode;
}



public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public int getZipcode() {
	return zipcode;
}
public void setZipcode(int zipcode) {
	this.zipcode = zipcode;
}




}
