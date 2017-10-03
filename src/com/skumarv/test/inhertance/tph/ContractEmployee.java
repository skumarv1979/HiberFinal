package com.skumarv.test.inhertance.tph;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="EmployeeTphCon")
@DiscriminatorValue(value="con")
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
