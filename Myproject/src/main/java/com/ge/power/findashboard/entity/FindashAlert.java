package com.ge.power.findashboard.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FINDASH_ALERT database table.
 * 
 */
@Entity
@Table(name="FINDASH_ALERT")
@NamedQueries({
	@NamedQuery(name="@GETALERTS",query="select c from FindashAlert c order by c.rDate,c.run,c.severity")
})
public class FindashAlert implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ALERT_ID")
	private BigDecimal alertId;

	@Column(name="CUSTOM_MESSAGE")
	private String customMessage;

	@Column(name="FULL_DESC")
	private String fullDesc;

	@Temporal(TemporalType.DATE)
	@Column(name="R_DATE")
	private Date rDate;

	@Column(name="R_MONTH")
	private BigDecimal rMonth;

	@Column(name="R_QUARTER")
	private BigDecimal rQuarter;

	@Column(name="R_YEAR")
	private BigDecimal rYear;

	private BigDecimal run;

	private BigDecimal severity;

	@Column(name="SHORT_DESC")
	private String shortDesc;

	public FindashAlert() {
	}

	public BigDecimal getAlertId() {
		return this.alertId;
	}

	public void setAlertId(BigDecimal alertId) {
		this.alertId = alertId;
	}

	public String getCustomMessage() {
		return this.customMessage;
	}

	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}

	public String getFullDesc() {
		return this.fullDesc;
	}

	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
	}

	public Date getRDate() {
		return this.rDate;
	}

	public void setRDate(Date rDate) {
		this.rDate = rDate;
	}

	public BigDecimal getRMonth() {
		return this.rMonth;
	}

	public void setRMonth(BigDecimal rMonth) {
		this.rMonth = rMonth;
	}

	public BigDecimal getRQuarter() {
		return this.rQuarter;
	}

	public void setRQuarter(BigDecimal rQuarter) {
		this.rQuarter = rQuarter;
	}

	public BigDecimal getRYear() {
		return this.rYear;
	}

	public void setRYear(BigDecimal rYear) {
		this.rYear = rYear;
	}

	public BigDecimal getRun() {
		return this.run;
	}

	public void setRun(BigDecimal run) {
		this.run = run;
	}

	public BigDecimal getSeverity() {
		return this.severity;
	}

	public void setSeverity(BigDecimal severity) {
		this.severity = severity;
	}

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

}