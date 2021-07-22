package com.example.ABC.model;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
//@Table(name = "product")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@NotEmpty(message="Name should not be null")
	private String name;
	
	@NotNull(message="Price should not be null")
	@Min(value = 1 , message = "Value should be greater than 0")
	private Double price;
	
	
	@Min(value = 0 , message = "Value should be greater than 0")
	@Max(value = 100, message = "Value should be less than 100")
	private Double promotion;
	
	@NotNull(message="Expired Date should not be null")
	@Column(name = "expired_date")
	private String expiredDate;
	
	@Min(value = 0 ,message = "Value should be greater than 0")
	@Max(value = 100, message = "Value should be less than 100")
	private Double tax;

	@NotNull(message="Quantity should not be null")
	private Integer quantity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getPromotion() {
		return promotion;
	}
	public void setPromotion(Double promotion) {
		this.promotion = promotion;
	}
	public String getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
}
