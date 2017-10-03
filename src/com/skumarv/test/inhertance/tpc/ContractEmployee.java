package com.skumarv.test.inhertance.tpc;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="EmployeeTpcCon")
@Table(name="CON_EMPLOYEE_TPC")
@AttributeOverrides({@AttributeOverride(name="id",column=@Column(name="ID")),
	@AttributeOverride(name="name",column=@Column(name="NAME"))})
public class ContractEmployee extends Employee {
	@Column(name="PAYPERHOUR")
	private float payPerHour;
	@Column(name="CONTRACTPERIOD")
	private String contractPeriod;
	public float getPayPerHour() {
		return payPerHour;
	}
	public void setPayPerHour(float payPerHour) {
		this.payPerHour = payPerHour;
	}
	public String getContractPeriod() {
		return contractPeriod;
	}
	public void setContractPeriod(String contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	
}
