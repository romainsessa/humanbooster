package com.hb.hibernate.repositories;

import com.hb.hibernate.model.Category;
import jakarta.persistence.EntityManager;

public class CategoryRepository {
	private EntityManager entityManager;

	public CategoryRepository(EntityManager entityManger) {
		this.entityManager = entityManger;
	}

	public void create(Category category) {
		entityManager.getTransaction().begin();
		entityManager.persist(category);
		entityManager.getTransaction().commit();
	}

	public Category read(Integer id) {
		return entityManager.find(Category.class, id);
	}

	public void update(Category category) {
		entityManager.getTransaction().begin();
		entityManager.merge(category);
		entityManager.getTransaction().commit();
	}

	public void delete(Category category) {
		entityManager.getTransaction().begin();
		entityManager.remove(category);
		entityManager.getTransaction().commit();
	}
}
