package com.valtech.training.invoicespringboot.components;

import java.util.List;

public interface ProductDAO {
	void createProduct(Product product);
	long count();
	void deleteProduct(int productId);
	void updateProduct(Product product);
	List<Product> getAllProduct();
	Product getProduct(int productId) ;

}
