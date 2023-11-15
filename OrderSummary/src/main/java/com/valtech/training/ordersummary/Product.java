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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float cost;
	@ManyToOne(targetEntity = Manufacturer.class, cascade = { CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
	private Manufacturer manufacturer;
	@OneToMany(targetEntity = OrderSummary.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
	private Set<OrderSummary> orderSummaries;

	public void addOrderSummary(OrderSummary orderSummary) {
		if (getOrderSummaries() == null) {
			setOrderSummaries(new HashSet<OrderSummary>());
		}
		getOrderSummaries().add(orderSummary);
		orderSummary.setProduct(this);
	}

	public Product() {
		super();
	}

	public Product(String name, float cost) {
		super();
		this.name = name;
		this.cost = cost;
	}

	public Product(String name, float cost, Manufacturer manufacturer) {
		super();
		this.name = name;
		this.cost = cost;
		this.manufacturer = manufacturer;
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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Set<OrderSummary> getOrderSummaries() {
		return orderSummaries;
	}

	public void setOrderSummaries(Set<OrderSummary> orderSummaries) {
		this.orderSummaries = orderSummaries;
	}

}
