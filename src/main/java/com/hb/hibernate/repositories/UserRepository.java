package com.hb.hibernate.repositories;

import java.util.List;

import org.hibernate.Session;

import com.hb.hibernate.model.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class UserRepository {

	private EntityManager entityManager;
	private Session session;

	public UserRepository(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.session = entityManager.unwrap(Session.class);
	}

	public void deleteUsers(List<User> users) {
		entityManager.getTransaction().begin();
		for (User user : users) {
			entityManager.remove(user);
		}
		entityManager.getTransaction().commit();
	}

	public void createUser(User user) {
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();

//		entityManager.getTransaction().begin();					
//		entityManager.persist(user);		
//		entityManager.getTransaction().commit();		
	}

	public List<User> getUsers() {
		entityManager.getTransaction().begin();
		List<User> users = entityManager.createQuery("from User", User.class).getResultList();

//		String queryStr = "from User";
//		Query query = entityManager.createQuery(queryStr, User.class);
//		List<User> users = query.getResultList();		
		entityManager.getTransaction().commit();
		return users;
	}

	public User getUser(Integer id) {
		entityManager.getTransaction().begin();
		User user = entityManager.find(User.class, id);
//		String queryStr = "from User where id= :id";
//		Query query = entityManager.createQuery(queryStr, User.class);
//		query.setParameter("id", id);
//		User user = (User) query.getSingleResult();
		entityManager.getTransaction().commit();
		return user;
	}

	public void deleteUser(User user) {
		entityManager.getTransaction().begin();
		entityManager.remove(user);
		entityManager.getTransaction().commit();
	}

	public void deleteUser(Integer id) {
		entityManager.getTransaction().begin();
		String queryStr = "delete from User where id= :id"; // Ecriture de la requete HQL où :id est un paramètre à
															// fournir
		Query query = entityManager.createQuery(queryStr); // Création de l'objet Query à partir de la requête
		query.setParameter("id", id); // On fournit le paramètre id à l'objet Query
		query.executeUpdate(); // On execute la Query
		entityManager.getTransaction().commit();
	}

	public void updateUser(User user) {
		entityManager.getTransaction().begin();
		entityManager.merge(user);
		entityManager.getTransaction().commit();
	}
}