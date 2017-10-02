package com.skumarv.test.entity;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="ADDITIONAL_CHANNEL")
@AssociationOverrides({@AssociationOverride(name="primary.cust",joinColumns=@JoinColumn(name="CUID")),
		@AssociationOverride(name="primary.channel",joinColumns=@JoinColumn(name="CHID"))})
public class AdditionalChannel {
	@EmbeddedId
	private AdditionalChannelId primary;
	@Column(name="START_DT")
	private Date stDate;
	@Column(name="END_DT")
	private Date endDate;
	public AdditionalChannelId getPrimary() {
		return primary;
	}
	public void setPrimary(AdditionalChannelId primary) {
		this.primary = primary;
	}
	public Date getStDate() {
		return stDate;
	}
	public void setStDate(Date stDate) {
		this.stDate = stDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
}
