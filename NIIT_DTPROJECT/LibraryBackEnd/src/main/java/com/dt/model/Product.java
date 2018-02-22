package com.dt.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int pid;
	private String pname;
	private String brandname;
	private Float price;
	private int stock;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Category category;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Supplier supplier;
	@Transient
	private MultipartFile image;
	
	
	public Supplier getSupplier() {
		return supplier;
	}
	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getBrandname() {
		return brandname;
	}
	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	

}
