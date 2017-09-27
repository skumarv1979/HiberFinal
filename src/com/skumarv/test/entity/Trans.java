package com.skumarv.test.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TRANS")
public class Trans {
	@Id
	@Column(name="TNO")
	@GeneratedValue
	private int txn;
	
	@Column(name="AMOUNT")
	private double amount;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Cust cust;
	
	public int getTxn() {
		return txn;
	}
	public void setTxn(int txn) {
		this.txn = txn;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Cust getCust() {
		return cust;
	}
	public void setCust(Cust cust) {
		this.cust = cust;
	}
}
