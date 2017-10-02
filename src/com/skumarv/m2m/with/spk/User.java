package com.skumarv.m2m.with.spk;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="UserWspk")
@Table(name="USER_WSPK")
public class User {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="EMAIL")
	private String email;
	
	@OneToMany(mappedBy="user")
	private Set<UserGroup> userGroup;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<UserGroup> getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(Set<UserGroup> userGroup) {
		this.userGroup = userGroup;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email
				+ ", userGroup=" + userGroup.size() + "]";
	}
	
}
