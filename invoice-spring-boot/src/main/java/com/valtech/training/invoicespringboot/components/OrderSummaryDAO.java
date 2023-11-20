package com.valtech.training.invoicespringboot.components;

import java.util.List;

public interface OrderSummaryDAO {
	void createOrderSummary(OrderSummary orderSummary);
	long count();

	void deleteOrderSummary(int id,int productId);
	void updateOrderSummary(OrderSummary orderSummary);
	List<OrderSummary> getAllOrderSummary();
	OrderSummary getOrderSummary(int id,int productId) ;

}
