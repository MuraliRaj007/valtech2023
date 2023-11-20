package com.valtech.training.invoicespringboot.components;

import java.util.List;

public interface CustomerDAO {
void createCustomer(Customer customer);
long count();

void deleteCustomer(int customerId);
void updateCustomer(Customer customer);
List<Customer> getAllCustomer();
Customer getCustomer(int customerId) ;

}
