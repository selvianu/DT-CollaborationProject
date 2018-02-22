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
public class Supplier {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int sid;
private String sname;
@OneToMany(cascade = CascadeType.ALL, mappedBy="supplier",targetEntity = Product.class)
private List<Product> product;

public List<Product> getProduct() {
	return product;
}
public void setProduct(List<Product> product) {
	this.product = product;
}
public int getSid() {
	return sid;
}
public void setSid(int sid) {
	this.sid = sid;
}
public String getSname() {
	return sname;
}
public void setSname(String sname) {
	this.sname = sname;
}



}
