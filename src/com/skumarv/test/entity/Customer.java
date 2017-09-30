package com.skumarv.test.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="CustomerTest")
@Table(name="CUSTOMER_TEST")
public class Customer {
	@Id
	@Column(name="CID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cno;
	@Column(name="NAME")
	private String name;
	@Embedded
	private Address address;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="SUBSCRIPTION", joinColumns={@JoinColumn(name="CID")},inverseJoinColumns={@JoinColumn(name="PID")})
	private Set<Pack> packs;
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Set<Pack> getPacks() {
		return packs;
	}
	public void setPacks(Set<Pack> packs) {
		this.packs = packs;
	}
	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", name=" + name + ", address="
				+ address + ", packs=" + packs + "]";
	}
	
}
