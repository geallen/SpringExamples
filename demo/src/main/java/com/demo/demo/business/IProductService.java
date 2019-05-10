package com.demo.demo.business;

import java.util.List;

import com.demo.demo.entities.Product;

public interface IProductService {

	List<Product> getAll();

	void add(Product product);

	void update(Product product);

	void delete(Product product);
	
	List<Product> getByCategoryId(int categoryId);
	
	List<Product> search(String productName, String description);
}
