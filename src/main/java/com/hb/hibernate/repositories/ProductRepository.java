package com.hb.hibernate.repositories;

import com.hb.hibernate.model.Product;

import jakarta.persistence.EntityManager;

public class ProductRepository {

	private EntityManager entityManager;

	public ProductRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public void create(Product product) {
		entityManager.getTransaction().begin();
		entityManager.persist(product);
		entityManager.getTransaction().commit();
	}

	public Product read(Integer id) {
		return entityManager.find(Product.class, id);
	}

	public void update(Product product) {
		entityManager.getTransaction().begin();
		entityManager.merge(product);
		entityManager.getTransaction().commit();
	}

	public void delete(Product product) {
		entityManager.getTransaction().begin();
		entityManager.remove(product);
		entityManager.getTransaction().commit();
	}

}
