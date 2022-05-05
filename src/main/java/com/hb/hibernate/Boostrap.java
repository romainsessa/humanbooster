package com.hb.hibernate;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hb.hibernate.model.Product;
import com.hb.hibernate.repositories.CategoryRepository;
import com.hb.hibernate.repositories.CommentRepository;
import com.hb.hibernate.repositories.ProductRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class Boostrap {

	private static Logger logger = LoggerFactory.getLogger(Boostrap.class);

	public static void main(String[] args) {

		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("com.hb.hibernate");
		EntityManager entityManager = entityFactory.createEntityManager();

		CategoryRepository categoryRepo = new CategoryRepository(entityManager);
		ProductRepository productRepo = new ProductRepository(entityManager);
		CommentRepository commentRepo = new CommentRepository(entityManager);

		// entityManager.getTransaction().begin();

		Product p = productRepo.read(1);
		p.setCost(40);

		ValidatorFactory factory = 
				Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Set<ConstraintViolation<Product>> violations = 
				validator.validate(p);

		if (violations.isEmpty()) {
			try {
				productRepo.update(p);
			} catch (Exception e) {
				logger.error(
						e.getClass() 
						+ " " 
						+ e.getMessage());
			}
		} else {
			for (ConstraintViolation<Product> violation : 
				violations) {
				logger.error(
						violation.getPropertyPath() 
						+ " : " 
						+ violation.getMessage());
			}
		}

		entityManager.close();
		entityFactory.close();

	}

}
