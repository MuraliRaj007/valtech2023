package com.valtech.training.ordersummary;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date orderDate;
	@ManyToOne(targetEntity = Customer.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private Customer customer;
	@OneToMany(targetEntity = OrderSummary.class, mappedBy = "order")
	private Set<OrderSummary> orderSummaries;

	public void addOrderSummaries(OrderSummary orderSummary) {
		if (getOrderSummaries() == null) {
			setOrderSummaries(new HashSet<OrderSummary>());
		}
		getOrderSummaries().add(orderSummary);
		orderSummary.setOrder(this);
	}

	public Order() {
		super();
	}

	public Order(Date orderDate) {
		super();
		this.orderDate = orderDate;
	}

	public Order(Date orderDate, Customer customer) {
		super();
		this.orderDate = orderDate;
		this.customer = customer;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<OrderSummary> getOrderSummaries() {
		return orderSummaries;
	}

	public void setOrderSummaries(Set<OrderSummary> orderSummaries) {
		this.orderSummaries = orderSummaries;
	}

}
