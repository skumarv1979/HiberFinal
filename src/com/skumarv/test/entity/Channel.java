package com.skumarv.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="Channel")
@Table(name="CHANNEL")
public class Channel {
	@Id
	@Column(name="CID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="NAME")
	private String name;
	@ManyToOne
	@JoinColumn(name="PACK_ID")
	private Pack pack;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Pack getPack() {
		return pack;
	}
	public void setPack(Pack pack) {
		this.pack = pack;
	}
	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + "]";
	}
	
}
