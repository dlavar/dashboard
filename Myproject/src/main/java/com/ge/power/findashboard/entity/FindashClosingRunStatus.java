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
 * The persistent class for the FINDASH_CLOSING_RUN_STATUS database table.
 * 
 */
@Entity
@Table(name="FINDASH_CLOSING_RUN_STATUS")
@NamedQueries({
	@NamedQuery(name="@FINDASHCLOSINGRUNSTATUSDETAILS", query="select c from FindashClosingRunStatus c order by c.rDate desc")
})
public class FindashClosingRunStatus implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Temporal(TemporalType.DATE)
	@Column(name="R_DATE")
	private Date rDate;

	@Column(name="R_MONTH_NUM")
	private BigDecimal rMonthNum;

	@Column(name="R_QUARTER")
	private String rQuarter;

	@Column(name="R_SOURCE")
	private String rSource;

	@Column(name="R_YEAR")
	private BigDecimal rYear;

	@Column(name="RUN_NUM")
	private BigDecimal runNum;

	private String status;

	public FindashClosingRunStatus() {
	}

	public Date getRDate() {
		return this.rDate;
	}

	public void setRDate(Date rDate) {
		this.rDate = rDate;
	}

	public BigDecimal getRMonthNum() {
		return this.rMonthNum;
	}

	public void setRMonthNum(BigDecimal rMonthNum) {
		this.rMonthNum = rMonthNum;
	}

	public String getRQuarter() {
		return this.rQuarter;
	}

	public void setRQuarter(String rQuarter) {
		this.rQuarter = rQuarter;
	}

	public String getRSource() {
		return this.rSource;
	}

	public void setRSource(String rSource) {
		this.rSource = rSource;
	}

	public BigDecimal getRYear() {
		return this.rYear;
	}

	public void setRYear(BigDecimal rYear) {
		this.rYear = rYear;
	}

	public BigDecimal getRunNum() {
		return this.runNum;
	}

	public void setRunNum(BigDecimal runNum) {
		this.runNum = runNum;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}