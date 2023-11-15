package com.valtech.training.ordersummary.client;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import com.valtech.training.ordersummary.Address;
import com.valtech.training.ordersummary.Customer;
import com.valtech.training.ordersummary.Manufacturer;
import com.valtech.training.ordersummary.Order;
import com.valtech.training.ordersummary.OrderSummary;
import com.valtech.training.ordersummary.Product;

public class OrderSummaryClient {

	public static void main(String[] args) throws ParseException {

		DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyy-HH-mm-ss");
		AnnotationConfiguration cfg = new AnnotationConfiguration();
		cfg.addAnnotatedClass(Customer.class).addAnnotatedClass(Manufacturer.class).addAnnotatedClass(Address.class)
				.addAnnotatedClass(Product.class).addAnnotatedClass(Order.class).addAnnotatedClass(OrderSummary.class);

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Address manufactureAddress = new Address("JP Nagar", "Bangalore", "560070");
		session.persist(manufactureAddress);
		Address customerAddress = new Address("Royal Circle", "Chintamani", "563125");
		session.persist(customerAddress);

		Manufacturer manufacturer = new Manufacturer("Apple", manufactureAddress);
		session.persist(manufacturer);
		
		Customer customer = new Customer("Murali", 1234, customerAddress);
		session.persist(customer);
		

		Product product = new Product("Iphone", 50000, manufacturer);
		session.persist(product);
		Product product1 = new Product("MacBook", 80000,manufacturer);
		session.persist(product1);
		
		manufacturer.addProduct(product);
		manufacturer.addProduct(product1);

		Order order = new Order(dateFormat.parse("06-11-2023-16-44-40"),customer);
		session.persist(order);
		Order order1=new Order(dateFormat.parse("07-11-2023-09-33-30"),customer);
		session.persist(order1);
		
		customer.addOrder(order);
		customer.addOrder(order1);
		
		OrderSummary orderSummary=new OrderSummary(order, product, 2);
		session.persist(orderSummary);
		OrderSummary orderSummary1=new OrderSummary(order, product1, 2);
		session.persist(orderSummary1);
		OrderSummary orderSummary2=new OrderSummary(order1, product, 2);
		session.persist(orderSummary2);
		OrderSummary orderSummary3=new OrderSummary(order1, product1, 2);
		session.persist(orderSummary3);
		
		order.addOrderSummary(orderSummary);
		order.addOrderSummary(orderSummary1);
		order1.addOrderSummary(orderSummary2);
		order1.addOrderSummary(orderSummary3);
		
		product.addOrderSummary(orderSummary);
		product.addOrderSummary(orderSummary2);
		product1.addOrderSummary(orderSummary1);
		product1.addOrderSummary(orderSummary3);


		System.out.println("Loading");
		transaction.commit();
		session.close();
		factory.close();
	}

}
