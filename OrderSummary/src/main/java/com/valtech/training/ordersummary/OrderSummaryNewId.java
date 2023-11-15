package com.valtech.training.ordersummary;

import java.io.Serializable;
import java.util.Objects;

public class OrderSummaryNewId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Order order;
	private Product product;

	public OrderSummaryNewId() {
		super();
	}

	public OrderSummaryNewId(Order order, Product product) {
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

	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderSummaryNewId other = (OrderSummaryNewId) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}

}
