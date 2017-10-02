package com.skumarv.m2m.with.spk;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name="GroupWspk")
@Table(name="GROUP_WSPK")
public class Group {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="NAME")
	private String name;
	@OneToMany(mappedBy="group")
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
	public Set<UserGroup> getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(Set<UserGroup> userGroup) {
		this.userGroup = userGroup;
	}
	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", userGroup="
				+ userGroup.size() + "]";
	}
	
}
