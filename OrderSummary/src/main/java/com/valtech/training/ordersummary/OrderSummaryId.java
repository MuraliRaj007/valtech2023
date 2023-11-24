package com.valtech.training.ordersummary;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class OrderSummaryId implements Serializable {

	@ManyToOne(targetEntity = Order.class)
	@JoinColumn(name = "orderId", referencedColumnName = "id")
	private Order order;
	@ManyToOne(targetEntity = Product.class)
	@JoinColumn(name = "productId", referencedColumnName = "id")
	private Product product;

	public OrderSummaryId() {
		super();
	}

	public OrderSummaryId(Order order, Product product) {
		super();
		this.order = order;
		this.product = product;
	}

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

}
