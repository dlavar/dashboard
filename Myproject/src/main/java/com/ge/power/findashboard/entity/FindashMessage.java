package com.ge.power.findashboard.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the FINDASH_MESSAGE database table.
 * 
 */
@Entity
@Table(name="FINDASH_MESSAGE")
@NamedQueries({
	@NamedQuery(name="@GETMESSAGES",query="select c from FindashMessage c order by c.rDate,c.run")
})
public class FindashMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="FULL_DESC")
	private String fullDesc;
	
	@Id
	@Column(name="MESSAGE_ID")
	private BigDecimal messageId;

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

	@Column(name="SHORT_DESC")
	private String shortDesc;

	public FindashMessage() {
	}

	public String getFullDesc() {
		return this.fullDesc;
	}

	public void setFullDesc(String fullDesc) {
		this.fullDesc = fullDesc;
	}

	public BigDecimal getMessageId() {
		return this.messageId;
	}

	public void setMessageId(BigDecimal messageId) {
		this.messageId = messageId;
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

	public String getShortDesc() {
		return this.shortDesc;
	}

	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}

}