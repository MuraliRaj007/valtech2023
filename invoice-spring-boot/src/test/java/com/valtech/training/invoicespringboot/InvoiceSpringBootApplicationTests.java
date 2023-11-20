package com.valtech.training.invoicespringboot;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.invoicespringboot.components.Address;
import com.valtech.training.invoicespringboot.components.AddressDAO;
import com.valtech.training.invoicespringboot.components.Company;
import com.valtech.training.invoicespringboot.components.CompanyDAO;
import com.valtech.training.invoicespringboot.components.CustomerDAO;
import com.valtech.training.invoicespringboot.components.OrderSummaryDAO;
import com.valtech.training.invoicespringboot.components.OrdersDAO;
import com.valtech.training.invoicespringboot.components.ProductDAO;




@SpringBootTest
class InvoiceSpringBootApplicationTests {
	
	@Autowired
	private AddressDAO addressDAO;
	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CustomerDAO customerDAO;

	@Autowired
	private OrdersDAO ordersDAO;
	
	@Autowired
	private OrderSummaryDAO orderSummaryDAO;
	

	@Test
	void testAddressDAO() {
		
		//create
//		Address address=new Address(3,"Jayanagar","Bangalore",560041);
//		addressDAO.createAddress(address);
//		assertEquals(3, addressDAO.count());
		
		//delete
//		addressDAO.deleteAddress(1);
//		assertEquals(1,addressDAO.count ());
		
		
		//GetAllAddress
		List<Address> address=addressDAO.getAllAddress();
		System.out.println(address);
		
		//GetAddress
//		Address address1=addressDAO.getAddress(1);
//		System.out.println(address1);
		
	}
	
//	@Test
//	void testCompanyDAO() {
//		
//		 Company  company=new  Company(102,"IBM",2);
//		 companyDAO.createCompany(company);
//		assertEquals(2,  companyDAO.count());
	

	//delete
//	 companyDAO.deleteCompany(1);
//	assertEquals(1, companyDAO.count ());
	
	
	//GetAllEmployees
//	List<Company>  company= companyDAO.getAllCompany();
//    System.out.println(Company);

	
	//GetEmployee
//	 Company  company= companyDAO.getCompany(1);
//	System.out.println(company);
	
//	}
	
//	@Test
//	void testProductDAO() {
//		
//		 Product product  =new  Product (102,"Iphone 14 pro",105000,101);
//		 productDAO.createProduct (product );
//		assertEquals(2,  productDAO.count());
	

	//delete
//	productDAO.deleteProduct(1);
//	productEquals(1,productDAO.count ());
	
	
	//GetAllProducts
//	List<Product>product=productDAO.getAllProduct();
//	System.out.println(product);
	
	//GetProduct
//	Product product=productDAO.getProduct(1);
//	System.out.println(product);
	
//	}
	
//	@Test
//	void testCustomerDAO() {
//		
//		Customer customer  =new  Customer (102,"Iphone 14 pro",105000,3);
//		customerDAO.createCustomer(customer);
//		assertEquals(1, customerDAO.count());
	

	//delete
//	customerDAO.deleteCustomer(1);
//	assertEquals(1,customerDAO.count ());
	
	
	//GetAllCustomer
//	List<Customer> customer=customerDAO.getAllCustomer();
//	System.out.println(customer);
	
	//GetCustomer
//	Customer customer=customerDAO.getCustomer(1);
//	System.out.println(customer);
	
//	}
	
//	@Test
//	void testOrdersDAO() {
//		
//		Orders orders  =new  Orders(101,null,102);
//		ordersDAO.createOrders(orders);
//		assertEquals(1, ordersDAO.count());
	
	

	//delete
//	OrdersDAO.deleteOrders(1);
//	assertEquals(1,OrdersDAO.count ());
	
	
	//GetAllOrders
//	List<Orders>orders=ordersDAO.getAllOrders();
//	System.out.println(orders);
	
	//GetOrders
//	Orders orders=ordersDAO.getOrders(1);
//	System.out.println(orders);
	
//	}
	
//	@Test
//	void testOrderSummaryDAO() {
//		
//		OrderSummary orderSummary  =new  OrderSummary(102,101,2);
//		orderSummaryDAO.createOrderSummary(orderSummary);
//		
	

	//delete
//	orderSummaryDAO.deleteOrderSummary(1);
//	assertEquals(1,orderSummaryDAO.count ());
	
	
	//GetAllOrderSummary
//	List<OrderSummary> orderSummary=orderSummaryDAO.getAllOrderSummary();
//	System.out.println(orderSummary);
	
	//GetEmployee
//	OrderSummary orderSummary=orderSummaryDAO.getOrderSummary(1);
//	System.out.println(orderSummary);
	
//	}
//	
	

}
