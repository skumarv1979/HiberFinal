package com.skumarv.test.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="Package")
@Table(name="PACKAGE")
public class Pack {
	@Id
	@Column(name="PID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="NAME")
	private String name;
	@OneToMany(mappedBy="pack",cascade=CascadeType.ALL)
	private Set<Channel> channels;
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
	public Set<Channel> getChannels() {
		return channels;
	}
	public void setChannels(Set<Channel> channels) {
		this.channels = channels;
	}
}
