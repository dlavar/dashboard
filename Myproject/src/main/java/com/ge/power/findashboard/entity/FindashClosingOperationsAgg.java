package com.ge.power.findashboard.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FINDASH_CLOSING_OPERATIONS_AGG database table.
 * 
 */
@Entity
@Table(name="FINDASH_CLOSING_OPERATIONS_AGG")
@NamedQueries({
	@NamedQuery(name="@GETOPERATIONALDETAILS",query="select c from FindashClosingOperationsAgg c")
})
public class FindashClosingOperationsAgg implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CLOSE_OP_KEY")
	private BigDecimal closeOpKey;

	@Column(name="GRAIN_IND")
	private String grainInd;

	@Column(name="JE_LINES")
	private BigDecimal jeLines;

	@Column(name="L_RUNS")
	private BigDecimal lRuns;

	@Temporal(TemporalType.DATE)
	@Column(name="R_DATE")
	private Date rDate;

	@Column(name="R_MONTH")
	private String rMonth;

	@Column(name="R_QUARTER")
	private String rQuarter;

	@Column(name="R_YEAR")
	private BigDecimal rYear;

	public FindashClosingOperationsAgg() {
	}

	public BigDecimal getCloseOpKey() {
		return this.closeOpKey;
	}

	public void setCloseOpKey(BigDecimal closeOpKey) {
		this.closeOpKey = closeOpKey;
	}

	public String getGrainInd() {
		return this.grainInd;
	}

	public void setGrainInd(String grainInd) {
		this.grainInd = grainInd;
	}

	public BigDecimal getJeLines() {
		return this.jeLines;
	}

	public void setJeLines(BigDecimal jeLines) {
		this.jeLines = jeLines;
	}

	public BigDecimal getLRuns() {
		return this.lRuns;
	}

	public void setLRuns(BigDecimal lRuns) {
		this.lRuns = lRuns;
	}

	public Date getRDate() {
		return this.rDate;
	}

	public void setRDate(Date rDate) {
		this.rDate = rDate;
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

	public BigDecimal getRYear() {
		return this.rYear;
	}

	public void setRYear(BigDecimal rYear) {
		this.rYear = rYear;
	}

}