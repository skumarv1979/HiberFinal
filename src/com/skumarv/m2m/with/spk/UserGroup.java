package com.skumarv.m2m.with.spk;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="UserGroupWspk")
@Table(name="USER_GROUP_WSPK")
public class UserGroup {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="UID")
	private User user;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="GID")
	private Group group;
	@Column(name="ACTIVATIONDT")
	private Date activationDt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public Date getActivationDt() {
		return activationDt;
	}
	public void setActivationDt(Date activationDt) {
		this.activationDt = activationDt;
	}
	@Override
	public String toString() {
		return "UserGroup [id=" + id + ", user=" + user + ", group=" + group
				+ ", activationDt=" + activationDt + "]";
	}
	
}
