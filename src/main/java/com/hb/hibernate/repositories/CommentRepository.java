package com.hb.hibernate.repositories;

import com.hb.hibernate.model.Comment;
import jakarta.persistence.EntityManager;

public class CommentRepository {

	private EntityManager entityManager;
	
	public CommentRepository(EntityManager entityManger) {
		this.entityManager = entityManger;
	}	
	
	public void create(Comment comment) {
		entityManager.getTransaction().begin();
		entityManager.persist(comment);
		entityManager.getTransaction().commit();		
	}
	
	public Comment read(Integer id) {
		return entityManager.find(Comment.class, id);
	}
	
	public void update(Comment comment) {
		entityManager.getTransaction().begin();
		entityManager.merge(comment);
		entityManager.getTransaction().commit();		
	}
	
	public void delete(Comment comment) {
		entityManager.getTransaction().begin();
		entityManager.remove(comment);
		entityManager.getTransaction().commit();		
	}	
		
}
