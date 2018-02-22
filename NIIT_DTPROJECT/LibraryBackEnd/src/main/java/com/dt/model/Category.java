package com.dt.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cid;
	private String cname;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="category",targetEntity = Product.class)
	 private List<Product> product;
	
		public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
		public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	

}
