package com.skumarv.o2m;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name="Cart")
@Table(name="CART")
public class Cart {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="TOTAL")
	private double total;
	
	@OneToMany(mappedBy="cart")
	@Cascade(value=CascadeType.ALL)
	private Set<Items> items;
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
	public Set<Items> getItems() {
		return items;
	}
	public void setItems(Set<Items> items) {
		this.items = items;
	}
}
