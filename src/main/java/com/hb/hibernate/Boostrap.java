package com.hb.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hb.hibernate.model.Comment;
import com.hb.hibernate.model.Product;
import com.hb.hibernate.repositories.CategoryRepository;
import com.hb.hibernate.repositories.CommentRepository;
import com.hb.hibernate.repositories.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Boostrap {

	private static Logger logger = LoggerFactory.getLogger(Boostrap.class);

	public static void main(String[] args) {

		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("com.hb.hibernate");
		EntityManager entityManager = entityFactory.createEntityManager();

		CategoryRepository categoryRepo = new CategoryRepository(entityManager);
		ProductRepository productRepo = new ProductRepository(entityManager);
		CommentRepository commentRepo = new CommentRepository(entityManager);

		entityManager.getTransaction().begin();
		
		Product p = productRepo.read(1);
		entityManager.remove(p);
		entityManager.flush();
		
		Product p2 = new Product();
		p2.setName("p1");
		
		entityManager.persist(p2);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityFactory.close();

	}

}
