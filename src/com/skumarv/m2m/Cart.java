package com.skumarv.m2m;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity(name="CartM2m")
@Table(name="CARTM2M")
public class Cart {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(name="TOTAL")
	private double total;
	
	@ManyToMany(targetEntity=com.skumarv.m2m.Item.class)
	@Cascade(value=CascadeType.ALL)
	@JoinTable(name = "CART_ITEMS", 
			joinColumns = { @JoinColumn(name = "cart_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "item_id") })
	private Set<Item> items;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Set<Item> getItems() {
		return items;
	}
	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
