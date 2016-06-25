package com.ge.power.findashboard.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the FINDASH_CLOSING_FINANCIALS_AGG database table.
 * 
 */
@Entity
@Table(name="FINDASH_CLOSING_FINANCIALS_AGG")
@NamedNativeQueries({ @NamedNativeQuery(name = "@GETDISTINCTQUATERENDDATES", query = " select distinct(TO_CHAR(C_DATE,'DD-MON-YYYY')) c_date from FINDASH_CLOSING_FINANCIALS_AGG order by C_DATE"),
	 @NamedNativeQuery(name = "@GETFINANCIALGRAPHDETAILS", query = " select * from FINDASH_CLOSING_FINANCIALS_AGG where C_DATE=:d")
})

@NamedQueries({
	@NamedQuery(name="@GETKPISDETAISL",query="select c.kpi,c.actuals,c.goal,c.cMonth,c.cDate,c.target,c.cYear,c.quarter,c.cId from FindashClosingFinancialsAgg c where c.kpi in :s" +
			" and c.cYear=:year and c.quarter=:quarter")
})

public class FindashClosingFinancialsAgg implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal actuals;

	@Temporal(TemporalType.DATE)
	@Column(name="C_DATE")
	private Date cDate;
	
	@Id
	@Column(name="C_ID")
	private String cId;

	@Column(name="C_MONTH")
	private String cMonth;

	@Column(name="C_YEAR")
	private Long cYear;

	private BigDecimal goal;

	private String kpi;

	private String quarter;

	private BigDecimal target;

	public FindashClosingFinancialsAgg() {
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

	public String getCId() {
		return this.cId;
	}

	public void setCId(String cId) {
		this.cId = cId;
	}

	public String getCMonth() {
		return this.cMonth;
	}

	public void setCMonth(String cMonth) {
		this.cMonth = cMonth;
	}

	public Long getCYear() {
		return this.cYear;
	}

	public void setCYear(Long cYear) {
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

	public BigDecimal getTarget() {
		return this.target;
	}

	public void setTarget(BigDecimal target) {
		this.target = target;
	}

}