package com.valtech.training.invoicespringboot.components;

import java.util.List;

public interface OrdersDAO {
	void createOrders(Orders order);
	long count();
	void deleteOrders(int id);
	void updateOrders(Orders orders);
	List<Orders> getAllOrders();
	Orders getOrder(int id) ;

}
