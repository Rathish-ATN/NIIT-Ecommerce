package com.niit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotEmpty(message="Enter Productname")
	private String productname;
	@NotEmpty(message="Enter Descrption")
	private String description;
	@Min(value=0,message="Enter Minimum 1")
	private int quantity;
	@Min(value=10,message="Mininum price must be 100")
	private int price;
	@ManyToOne
	private Catagory catagory;
	@Transient
	private MultipartFile image;
	
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Catagory getCatagory() {
		return catagory;
	}
	public void setCatagory(Catagory catagory) {
		this.catagory = catagory;
	}
	// System.out.println(product) ->toString() in Object class ->com.niit.model.Product@39839
	//System.out.println(product) ->toString() in Product class ->
	//${product} ->toString()
	//${product.productname}} ->product.getProductName()
	@Override
	public String toString() {
	return "id " + this.id + " ProductName" + this.productname + " " + " Desc " + this.description + " Price " + this.price;
	}	
	

}
