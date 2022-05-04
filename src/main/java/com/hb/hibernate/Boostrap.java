package com.hb.hibernate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hb.hibernate.model.Comment;
import com.hb.hibernate.model.Product;
import com.hb.hibernate.model.User;
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

		ProductRepository productRepo = new ProductRepository(entityManager);
		Product product = productRepo.read(1);
		
		CommentRepository commentRepo = new CommentRepository(entityManager);
		Comment retrievedComment = commentRepo.read(1);
		logger.info(retrievedComment.getContent() + " loaded");
		logger.info(retrievedComment.getProduct().getName() + " loaded");
		
		entityManager.close();
		entityFactory.close();
		

//		
//		Product product1 = new Product();
//		product1.setName("iphone36");
//		product1.setDescription("un téléphone qui coute cher");
//		product1.setCost(10000);
//		
//		productRepo.create(product1);
//
//		Product retrievedProduct = productRepo.read(1);
//		System.out.println("Le produit a été récupéré : " + retrievedProduct.getCost());
//				
//				
//		Comment myComment = new Comment();
//		myComment.setContent("Commentaire pour le produit 1");
//		myComment.setProduct(retrievedProduct);
//		commentRepo.create(myComment);
//		
//		productRepo.close();
//		commentRepo.close();
		
//		product1.setProductId(1);
//		product1.setCost(2000);
//		productRepo.update(product1);		
//		
//		retrievedProduct = productRepo.read(1);
//		System.out.println("Le produit a été récupéré : " + retrievedProduct.getCost());
//
//		productRepo.delete(product1);
//		
//		retrievedProduct = productRepo.read(1);
//		if(retrievedProduct == null) {
//			System.out.println("Le produit n'existe plus");
//		}
//			
	}
	

}
