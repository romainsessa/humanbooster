package com.hb.hibernate.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;

	@Column
	private String name;

	@Column
	private String description;

	@Column
	private Integer cost;

	@OneToMany(mappedBy = "product", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Comment> comments = new ArrayList<Comment>();

	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
	private ProductDetails productDetails;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void addComment(Comment comment) {
		comments.add(comment);
		comment.setProduct(this);
	}

	public void removeComment(Comment comment) {
		comments.remove(comment);
		comment.setProduct(null);
	}

	public ProductDetails getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(ProductDetails productDetails) {
		this.productDetails = productDetails;
		productDetails.setProduct(this);
	}

}
