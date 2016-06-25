package com.ge.power.findashboard.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FINDASH_PROCESSING_RATE database table.
 * 
 */
@Entity
@Table(name="FINDASH_PROCESSING_RATE")
@NamedQueries({
	@NamedQuery(name="@GETPROCESSINGDETAILS",query="select c from FindashProcessingRate c order by c.rDate,c.run")
})
public class FindashProcessingRate implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="PROC_RATE_ID")
	private BigDecimal procRateId;

	@Column(name="PROCESSING_TIME")
	private BigDecimal processingTime;

	@Temporal(TemporalType.DATE)
	@Column(name="R_DATE")
	private Date rDate;

	@Column(name="R_MONTH")
	private BigDecimal rMonth;

	@Column(name="R_QUARTER")
	private BigDecimal rQuarter;

	@Column(name="R_YEAR")
	private BigDecimal rYear;

	@Column(name="RECORDS_PER_MINUTE")
	private BigDecimal recordsPerMinute;

	private BigDecimal run;

	@Column(name="TOTAL_RECORDS")
	private BigDecimal totalRecords;

	public FindashProcessingRate() {
	}

	public BigDecimal getProcRateId() {
		return this.procRateId;
	}

	public void setProcRateId(BigDecimal procRateId) {
		this.procRateId = procRateId;
	}

	public BigDecimal getProcessingTime() {
		return this.processingTime;
	}

	public void setProcessingTime(BigDecimal processingTime) {
		this.processingTime = processingTime;
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

	public BigDecimal getRecordsPerMinute() {
		return this.recordsPerMinute;
	}

	public void setRecordsPerMinute(BigDecimal recordsPerMinute) {
		this.recordsPerMinute = recordsPerMinute;
	}

	public BigDecimal getRun() {
		return this.run;
	}

	public void setRun(BigDecimal run) {
		this.run = run;
	}

	public BigDecimal getTotalRecords() {
		return this.totalRecords;
	}

	public void setTotalRecords(BigDecimal totalRecords) {
		this.totalRecords = totalRecords;
	}

}