package com.valtech.training.ordersummary;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class OrderSummary {

	@EmbeddedId
	private OrderSummaryId id;
	@ManyToOne
	@JoinColumn(name = "orderId", insertable = false, updatable = false)
	private Order order;

	@ManyToOne
	@JoinColumn(name = "productId", insertable = false, updatable = false)
	private Product product;

	private int quantity;

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderSummary() {
		super();
	}

	public OrderSummary(OrderSummaryId id, int quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}

	public OrderSummaryId getId() {
		return id;
	}

	public void setId(OrderSummaryId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
