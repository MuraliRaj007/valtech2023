package com.valtech.training.ordersummary;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int phNum;
	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	@OneToMany(targetEntity = Order.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customer")
	private Set<Order> orders;

	public void addOrder(Order order) {
		if (getOrders() == null) {
			setOrders(new HashSet<Order>());
		}
		getOrders().add(order);
		order.setCustomer(this);
	}

	public Customer() {
		super();
	}

	public Customer(String name, int phNum) {
		super();
		this.name = name;
		this.phNum = phNum;
	}

	public Customer(String name, int phNum, Address address) {
		super();
		this.name = name;
		this.phNum = phNum;
		this.address = address;
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

	public int getPhNum() {
		return phNum;
	}

	public void setPhNum(int phNum) {
		this.phNum = phNum;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
