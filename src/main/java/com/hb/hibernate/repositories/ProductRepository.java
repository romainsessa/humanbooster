package com.hb.hibernate.repositories;

import java.util.List;

import com.hb.hibernate.dto.ProductDTO;
import com.hb.hibernate.dto.ProductLight;
import com.hb.hibernate.model.Product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

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

	public List<ProductLight> getProductLights() {
		String strQuery = "select new "
				+ "com.hb.hibernate.dto.ProductLight( "
				+ "p.id, p.name )"
				+ "from Product p";
		Query query = entityManager.createQuery(strQuery);		
		List<ProductLight> products = query.getResultList();		
		return products;
	}
	
	public ProductLight getProductLightByName(String name) {
		String strQuery = "select new "
				+ "com.hb.hibernate.dto.ProductLight( "
				+ "p.id, p.name )"
				+ "from Product p "
				+ "where p.name = :name";
		Query query = entityManager.createQuery(strQuery);
		query.setParameter("name", name);
		return (ProductLight) query.getSingleResult();		
	}
	
	public List<ProductDTO> getProductDTOs() {
		String strQuery = "select new "
				+ "com.hb.hibernate.dto.ProductDTO("
				+ "p.id, p.name, d.createdBy) "
				+ "from Product p "
				+ "join p.productDetails d";
		Query query = entityManager.createQuery(strQuery);
		return query.getResultList();
	}
	
	
}
