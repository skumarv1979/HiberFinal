package com.skumarv.m2mtest;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="UsersTest")
@Table(name="USERS_TEST")
public class Users {
	@Id
	@Column(name="NO")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="NAME")
	private String name;
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="users")
	private Set<Groups> groups;
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
	public Set<Groups> getGroups() {
		return groups;
	}
	public void setGroups(Set<Groups> groups) {
		this.groups = groups;
	}
}
