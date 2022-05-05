package com.hb.hibernate.dto;

public class ProductDTO {

	private Integer id;
	
	private String name;
	
	private String createdBy;

	public ProductDTO() {	}	

	public ProductDTO(Integer id, String name, String createdBy) {
		this.id = id;
		this.name = name;
		this.createdBy = createdBy;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
	
	
	
}
