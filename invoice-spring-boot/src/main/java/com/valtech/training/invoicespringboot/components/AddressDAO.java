package com.valtech.training.invoicespringboot.components;

import java.util.List;

public interface AddressDAO {
	void createAddress(Address address) ;
	long count() ;
	
	void deleteAddress(int id);
	void updateAddress(Address address);
	List<Address> getAllAddress();
	Address getAddress(int id) ;

}
