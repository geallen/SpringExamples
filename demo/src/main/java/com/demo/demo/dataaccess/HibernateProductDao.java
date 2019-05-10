package com.demo.demo.dataaccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.demo.entities.Product;

@Repository
public class HibernateProductDao implements IProductDao {

	EntityManager entityManager;

	@Autowired
	public HibernateProductDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Product> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Product> products = session.createQuery("from Product", Product.class).getResultList();

		return products;

	}

	@Override
	public void add(Product product) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(product);

	}

	@Override
	public void update(Product product) {
		Session session = entityManager.unwrap(Session.class);
		session.update(product);
	}

	@Override
	public void delete(Product product) {
		Session session = entityManager.unwrap(Session.class);
		session.remove(session.contains(product) ? product : session.merge(product));
//		session.delete(product);

	}

	@Override
	public List<Product> getByCategoryId(int categoryId) {
		Session session = entityManager.unwrap(Session.class);
		List<Product> products = session.createQuery("from Product p where p.categoryId=" + categoryId, Product.class).getResultList();
		return products;
	}
	@Override
	public List<Product> search(String productName, String description){
		Session session = entityManager.unwrap(Session.class);
		List<Product> products = session.createQuery("from Product p where p.productName ='" + productName + "' AND p.description='" + description + "'", Product.class).getResultList();
		return products;
	}
}
