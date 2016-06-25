package com.ge.power.findashboard.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the FINDASH_CLOSING_SCHEDULES database table.
 * 
 */
@Entity
@Table(name="FINDASH_CLOSING_SCHEDULES")
@NamedQueries({
	@NamedQuery(name="@GETSECHEDULESINFO",query="select c from FindashClosingSchedule c order by c.schTime")
})
public class FindashClosingSchedule implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="R_DATE")
	private Date rDate;

	@Column(name="R_MONTH")
	private BigDecimal rMonth;

	@Column(name="R_QUARTER")
	private String rQuarter;

	@Column(name="R_YEAR")
	private BigDecimal rYear;

	@Column(name="SCH_DESC")
	private String schDesc;

	@Column(name="SCH_NAME")
	private String schName;

	@Column(name="SCH_TIME")
	private String schTime;

	public FindashClosingSchedule() {
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

	public String getRQuarter() {
		return this.rQuarter;
	}

	public void setRQuarter(String rQuarter) {
		this.rQuarter = rQuarter;
	}

	public BigDecimal getRYear() {
		return this.rYear;
	}

	public void setRYear(BigDecimal rYear) {
		this.rYear = rYear;
	}

	public String getSchDesc() {
		return this.schDesc;
	}

	public void setSchDesc(String schDesc) {
		this.schDesc = schDesc;
	}

	public String getSchName() {
		return this.schName;
	}

	public void setSchName(String schName) {
		this.schName = schName;
	}

	public String getSchTime() {
		return this.schTime;
	}

	public void setSchTime(String schTime) {
		this.schTime = schTime;
	}

}