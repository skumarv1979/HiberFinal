package com.skumarv.o2m;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Items")
@Table(name="ITEMS")
public class Items {
	@Id
	@Column(name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="NAME")
	private String name;
	@Column(name="TOTAL")
	private double total;
	@Column(name="QUANTITY")
	private int quantity;
	@ManyToOne
	@JoinColumn(name="cartId",nullable=false)
	private Cart cart;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
