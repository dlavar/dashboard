package com.ge.power.findashboard.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the FINDASH_QUARTER database table.
 * 
 */
@Entity
@Table(name="FINDASH_QUARTER")
@NamedQuery(name="@GETTQUATERENDDATES" ,query = "select q.quarter,q.eDate from FindashQuarter q order by q.quarter desc")
public class FindashQuarter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	@Column(name="E_DATE")
	private Date eDate;

	@Id
	private String quarter;
	@Id
	@Column(name="R_YEAR")
	private BigDecimal rYear;

	@Temporal(TemporalType.DATE)
	@Column(name="S_DATE")
	private Date sDate;

	public FindashQuarter() {
	}

	public Date getEDate() {
		return this.eDate;
	}

	public void setEDate(Date eDate) {
		this.eDate = eDate;
	}

	public String getQuarter() {
		return this.quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public BigDecimal getRYear() {
		return this.rYear;
	}

	public void setRYear(BigDecimal rYear) {
		this.rYear = rYear;
	}

	public Date getSDate() {
		return this.sDate;
	}

	public void setSDate(Date sDate) {
		this.sDate = sDate;
	}

}