package com.ge.power.findashboard.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;


/**
 * The persistent class for the FINDASH_CLOSING_FINANCIALS_RAW database table.
 * 
 */
@Entity
@IdClass(FindashClosingFinancialsRawPK.class)
@Table(name="FINDASH_CLOSING_FINANCIALS_RAW")
@NamedQuery(name="FindashClosingFinancialsRaw.findAll", query="SELECT f FROM FindashClosingFinancialsRaw f")

public class FindashClosingFinancialsRaw implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="C_ID")
	private String cId;
	
	
	private BigDecimal actuals;

	@Temporal(TemporalType.DATE)
	@Column(name="C_DATE")
	private Date cDate;
	
	
	@Column(name="C_MONTH")
	private String cMonth;
	
	
	@Id	
	@Column(name="C_YEAR")
	private BigDecimal cYear;
	
	private BigDecimal goal;
	
	private String kpi;
	
	@Id
	@Column(name="QUARTER")
	private String quarter;
	
	@Id
	@Column(name="SECTION")
	private String section;
	
	private BigDecimal target;

	//bi-directional many-to-one association to FindashClosingFinancialsAgg
	/*
	@ManyToOne	
	@JoinColumn(name="C_ID", referencedColumnName="C_ID")
	private FindashClosingFinancialsAgg findashClosingFinancialsAgg;
*/
	public FindashClosingFinancialsRaw() {
	}
	
	
	public String getcId() {
		return cId;
	}


	public void setcId(String cId) {
		this.cId = cId;
	}


	public BigDecimal getActuals() {
		return this.actuals;
	}

	public void setActuals(BigDecimal actuals) {
		this.actuals = actuals;
	}

	public Date getCDate() {
		return this.cDate;
	}

	public void setCDate(Date cDate) {
		this.cDate = cDate;
	}

	public String getCMonth() {
		return this.cMonth;
	}

	public void setCMonth(String cMonth) {
		this.cMonth = cMonth;
	}

	public BigDecimal getCYear() {
		return this.cYear;
	}

	public void setCYear(BigDecimal cYear) {
		this.cYear = cYear;
	}

	public BigDecimal getGoal() {
		return this.goal;
	}

	public void setGoal(BigDecimal goal) {
		this.goal = goal;
	}

	public String getKpi() {
		return this.kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
	}

	public String getQuarter() {
		return this.quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getSection() {
		return this.section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public BigDecimal getTarget() {
		return this.target;
	}

	public void setTarget(BigDecimal target) {
		this.target = target;
	}

	/*public FindashClosingFinancialsAgg getFindashClosingFinancialsAgg() {
		return this.findashClosingFinancialsAgg;
	}

	public void setFindashClosingFinancialsAgg(FindashClosingFinancialsAgg findashClosingFinancialsAgg) {
		this.findashClosingFinancialsAgg = findashClosingFinancialsAgg;
	}
*/
}