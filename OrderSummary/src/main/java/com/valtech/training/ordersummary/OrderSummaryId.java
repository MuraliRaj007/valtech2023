package com.valtech.training.ordersummary;

import java.io.Serializable;
import java.util.Objects;

public class OrderSummaryId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int order;
	private int product;

	public OrderSummaryId() {
		super();
	}

	public OrderSummaryId(int orderId, int productId) {
		super();
		this.order = orderId;
		this.product = productId;
	}

	public int getOrder() {
		return order;
	}

	public void setOrder(int orderId) {
		this.order = orderId;
	}

	public int getProduct() {
		return product;
	}

	public void setProduct(int productId) {
		this.product = productId;
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
		OrderSummaryId other = (OrderSummaryId) obj;
		return order == other.order && product == other.product;
	}

}
