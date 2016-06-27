package com.ge.power.findashboard.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the FINDASH_CLOSING_FINANCIALS_AGG database table.
 * 
 */
@Entity
@IdClass(FindashClosingFinancialsAggPK.class)
@Table(name="FINDASH_CLOSING_FINANCIALS_AGG")
@NamedNativeQueries({ @NamedNativeQuery(name = "@GETDISTINCTQUATERENDDATES", query = " select distinct(TO_CHAR(C_DATE,'DD-MON-YYYY')) c_date from FINDASH_CLOSING_FINANCIALS_AGG order by C_DATE"),
	 @NamedNativeQuery(name = "@GETFINANCIALGRAPHDETAILS", query = " select * from FINDASH_CLOSING_FINANCIALS_AGG where C_DATE=:d")
})

@NamedQueries({
	@NamedQuery(name="@GETKPISDETAISL",query="select c from FindashClosingFinancialsAgg c where c.kpi in :s" +
			" and c.cYear=:year and c.quarter=:quarter"),
	@NamedQuery(name="FindashClosingFinancialsAgg.findAll", query="SELECT f FROM FindashClosingFinancialsAgg f")
})

public class FindashClosingFinancialsAgg implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private BigDecimal actuals;
	
	
	@Column(name="C_ID")
	private String cId;
	
	@Temporal(TemporalType.DATE)
	@Column(name="C_DATE")
	private Date cDate;
	
	@Column(name="C_MONTH")
	private String cMonth;
	
	@Id
	@Column(name="C_YEAR")
	private Long cYear;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	private BigDecimal goal;
	
	@Id
	private String kpi;
	
	@Id
	@Column(name="QUARTER")
	private String quarter;
	
	private BigDecimal target;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	//bi-directional many-to-one association to FindashClosingFinancialsRaw
/*	
	@OneToMany
	@JoinColumn(name="C_ID", referencedColumnName="C_ID")
	private List<FindashClosingFinancialsRaw> findashClosingFinancialsRaws;
*/
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

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	/*public List<FindashClosingFinancialsRaw> getFindashClosingFinancialsRaws() {
		return this.findashClosingFinancialsRaws;
	}

	public void setFindashClosingFinancialsRaws(List<FindashClosingFinancialsRaw> findashClosingFinancialsRaws) {
		this.findashClosingFinancialsRaws = findashClosingFinancialsRaws;
	}*/

	/*public FindashClosingFinancialsRaw addFindashClosingFinancialsRaw(FindashClosingFinancialsRaw findashClosingFinancialsRaw) {
		getFindashClosingFinancialsRaws().add(findashClosingFinancialsRaw);
		//findashClosingFinancialsRaw.setFindashClosingFinancialsAgg(this);

		return findashClosingFinancialsRaw;
	}

	public FindashClosingFinancialsRaw removeFindashClosingFinancialsRaw(FindashClosingFinancialsRaw findashClosingFinancialsRaw) {
		getFindashClosingFinancialsRaws().remove(findashClosingFinancialsRaw);
		//findashClosingFinancialsRaw.setFindashClosingFinancialsAgg(null);

		return findashClosingFinancialsRaw;
	}
*/
}