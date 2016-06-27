package com.ge.power.findashboard.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the FINDASH_CLOSING_FINANCE_PLAN database table.
 * 
 */
@Entity
@Table(name="FINDASH_CLOSING_FINANCE_PLAN")
@NamedQueries({
	@NamedQuery(name="FindashClosingFinancePlan.findAll", query="SELECT f FROM FindashClosingFinancePlan f"),
	@NamedQuery(name="@GETGOALDETAILSDAILY",query="select f from FindashClosingFinancePlan f where f.grainInd=:grainind and f.rQuarter=:quarter"
	+ " and f.rYear=:year")})
public class FindashClosingFinancePlan implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="GRAIN_IND")
	private String grainInd;

	@Column(name="OP_PLAN")
	private BigDecimal opPlan;

	@Column(name="ORDERS_PLAN")
	private BigDecimal ordersPlan;

	@Column(name="R_MONTH")
	private String rMonth;

	@Column(name="R_QUARTER")
	private String rQuarter;
	
	@Id
	@Column(name="R_YEAR")
	private Long rYear;

	@Column(name="REVENUE_PLAN")
	private BigDecimal revenuePlan;

	public FindashClosingFinancePlan() {
	}

	public String getGrainInd() {
		return this.grainInd;
	}

	public void setGrainInd(String grainInd) {
		this.grainInd = grainInd;
	}

	public BigDecimal getOpPlan() {
		return this.opPlan;
	}

	public void setOpPlan(BigDecimal opPlan) {
		this.opPlan = opPlan;
	}

	public BigDecimal getOrdersPlan() {
		return this.ordersPlan;
	}

	public void setOrdersPlan(BigDecimal ordersPlan) {
		this.ordersPlan = ordersPlan;
	}

	public String getRMonth() {
		return this.rMonth;
	}

	public void setRMonth(String rMonth) {
		this.rMonth = rMonth;
	}

	public String getRQuarter() {
		return this.rQuarter;
	}

	public void setRQuarter(String rQuarter) {
		this.rQuarter = rQuarter;
	}

	public Long getRYear() {
		return this.rYear;
	}

	public void setRYear(Long rYear) {
		this.rYear = rYear;
	}

	public BigDecimal getRevenuePlan() {
		return this.revenuePlan;
	}

	public void setRevenuePlan(BigDecimal revenuePlan) {
		this.revenuePlan = revenuePlan;
	}

}