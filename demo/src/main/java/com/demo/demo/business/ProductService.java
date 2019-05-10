package com.demo.demo.business;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.demo.dataaccess.IProductDao;
import com.demo.demo.entities.Product;

@Service
public class ProductService implements IProductService{

	IProductDao productDao;
	
	@Autowired
	public ProductService(IProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	@Transactional
	public List<Product> getAll() {
		return productDao.getAll();
	}

	@Override
	@Transactional
	public void add(Product product) {
		productDao.add(product);
		
	}

	@Override
	@Transactional
	public void update(Product product) {
		productDao.update(product);
		
	}

	@Override
	@Transactional
	public void delete(Product product) {
		productDao.delete(product);
		
	}
	
	@Override
	@Transactional
	public List<Product> getByCategoryId(int categoryId){
		return productDao.getByCategoryId(categoryId);
	}
	
	@Override
	@Transactional
	public List<Product> search(String productName, String description){
		return productDao.search(productName, description);
	}
	
}
