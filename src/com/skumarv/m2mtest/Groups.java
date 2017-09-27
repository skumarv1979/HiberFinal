package com.skumarv.m2mtest;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name = "GroupsTest")
@Table(name = "GROUPS_TEST")
public class Groups {
	@Id
	@Column(name = "NUM")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "NAME")
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USERS_GROUPS_TEST", joinColumns = { @JoinColumn(name = "GNO") }, inverseJoinColumns = { @JoinColumn(name = "UNO") })
	private Set<Users> users;

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

	public Set<Users> getUsers() {
		return users;
	}

	public void setUsers(Set<Users> users) {
		this.users = users;
	}
}
