package com.ge.power.findashboard.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.ws.rs.DefaultValue;


/**
 * The persistent class for the FIN_DASH_BATCH_TRACKER database table.
 * 
 */
@Entity
@Table(name="FIN_DASH_BATCH_TRACKER")
@NamedQuery(name="FinDashBatchTracker.findAll", query="SELECT f FROM FinDashBatchTracker f")
@NamedStoredProcedureQueries({
	   @NamedStoredProcedureQuery(name = "Pacing_Err_Chk", 
	                              procedureName = "Pacing_Err_Chk",
	                              parameters = {
	                                 @StoredProcedureParameter(mode = ParameterMode.IN, name = "BatchId", type = Integer.class),
	                                 @StoredProcedureParameter(mode = ParameterMode.OUT, name = "Flag", type = Integer.class)
	                              })
})
	
//@NamedNativeQuery(name="@getBatchId", query="SELECT FINDASH_TRACKER.NEXTVAL FROM DUAL")
public class FinDashBatchTracker implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="BATCH_ID")
	private int batchId;

	@Column(name="CREATED_BY")
	@DefaultValue(value="Application")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	private String status;

	@Column(name="STATUS_CODE")
	private String statusCode;

	@Column(name="UPDATED_BY")
	@DefaultValue(value="Application")
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	public FinDashBatchTracker() {
	}

	public int getBatchId() {
		return this.batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
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

}