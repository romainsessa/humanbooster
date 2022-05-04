package com.hb.hibernate.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productDetailsId;

	@Column
	private Date createdDate;

	@Column
	private String createdBy;

	@OneToOne
	@JoinColumn(name = "productId")
	private Product product;

	public Integer getProductDetailsId() {
		return productDetailsId;
	}

	public void setProductDetailsId(Integer productDetailsId) {
		this.productDetailsId = productDetailsId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}