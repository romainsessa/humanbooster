package com.hb.hibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Boostrap {

	private static Logger logger = LoggerFactory.getLogger(Boostrap.class);

	public static void main(String[] args) {

		EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("com.hb.hibernate");
		EntityManager entityManager = entityFactory.createEntityManager();

		// Executer les opérations souhaitées sur les entités.

		entityManager.close();
		entityFactory.close();

	}

}
