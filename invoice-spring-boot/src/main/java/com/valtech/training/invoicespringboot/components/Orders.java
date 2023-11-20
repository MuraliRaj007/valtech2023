package com.valtech.training.invoicespringboot.components;

import java.sql.Date;

public class Orders {
int id;
Date orderDate;
int customerId;

public Orders() {
}

public Orders(int id, Date orderDate, int customerId) {
	this.id = id;
	this.orderDate = orderDate;
	this.customerId = customerId;
}

public Orders(Date orderDate, int customerId) {
	
	this.orderDate = orderDate;
	this.customerId = customerId;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getOrderDate() {
	return orderDate;
}
public void setOrderDate(Date orderDate) {
	 this.orderDate = orderDate;
}

public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}



}
