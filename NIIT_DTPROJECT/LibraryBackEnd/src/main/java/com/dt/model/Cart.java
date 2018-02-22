package com.dt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int citemid;
	private int cartid;
	private int id;
	private int quantity;
	private Float prize;
	private String uname;
	private String name;
	private String status;

	public int getCitemid() {
		return citemid;
	}

	public void setCitemid(int citemid) {
		this.citemid = citemid;
	}

	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Float getPrize() {
		return prize;
	}

	public void setPrize(Float float1) {
		this.prize = float1;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Cart [citemid=" + citemid + ", cartid=" + cartid + ", id=" + id + ", quantity=" + quantity + ", prize="
				+ prize + ", uname=" + uname + ", name=" + name + ", status=" + status + "]";
	}

}
