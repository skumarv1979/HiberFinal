package com.skumarv.test.inhertance.tps;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name="EmployeeTpsReg")
@Table(name="REG_EMPLOYEE_TPS")
@PrimaryKeyJoinColumn(name="ID")
public class RegularEmployee extends Employee {
	@Column(name="SALARY")
	private float salary;
	@Column(name="BONUS")
	private int bonus;
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
}
