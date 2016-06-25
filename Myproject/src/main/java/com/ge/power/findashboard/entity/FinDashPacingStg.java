package com.ge.power.findashboard.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the FIN_DASH_PACING_STG database table.
 * 
 */
@Entity
@Table(name="FIN_DASH_PACING_STG")
@NamedQuery(name="FinDashPacingStg.findAll", query="SELECT f FROM FinDashPacingStg f")
public class FinDashPacingStg implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FinDashPacingStgPK id;

	@Column(name="BATCH_ID")
	private String batchId;

	

	@Column(name="COUNTRY_OF_ORIGIN")
	private String countryOfOrigin;

	@Column(name="COUNTRY_US_STATE")
	private String countryUsState;

	@Column(name="CREATED_BY")
	private String createdBy;

	/*@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;*/
	
	//@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private String createdDate;

	private String customer;



	@Column(name="EQUIP_SERV")
	private String equipServ;

	@Column(name="EXT_OGE_OI")
	private String extOgeOi;


	@Column(name="GE_CONTRACT_CODE")
	private String geContractCode;



	private String ips;

	private String model;

	@Column(name="ORDER_SALE")
	private String orderSale;

	@Column(name="ORDER_SALE_MARGIN")
	private String orderSaleMargin;

	
	@Column(name="PROJECT_NAME")
	private String projectName;

	

	@Column(name="SEGMENT")
	private String segment;

	@Column(name="SUB_BUSINESS")
	private String subBusiness;

	@Column(name="UNIT_COUNT")
	private String unitCount;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	/*@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;*/
	
	//@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private String updatedDate;

	@Column(name="USEXPORT_DOM_INTL")
	private String usexportDomIntl;

	public FinDashPacingStg() {
		this.id = new FinDashPacingStgPK();
	}

	public FinDashPacingStgPK getId() {
		return this.id;
	}

	public void setId(FinDashPacingStgPK id) {
		this.id = new FinDashPacingStgPK();
	}

	public String getBatchId() {
		return this.batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}



	public String getCountryOfOrigin() {
		return this.countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin) {
		this.countryOfOrigin = countryOfOrigin;
	}

	public String getCountryUsState() {
		return this.countryUsState;
	}

	public void setCountryUsState(String countryUsState) {
		this.countryUsState = countryUsState;
	}

	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	

	public String getEquipServ() {
		return this.equipServ;
	}

	public void setEquipServ(String equipServ) {
		this.equipServ = equipServ;
	}

	public String getExtOgeOi() {
		return this.extOgeOi;
	}

	public void setExtOgeOi(String extOgeOi) {
		this.extOgeOi = extOgeOi;
	}

	

	public String getGeContractCode() {
		return this.geContractCode;
	}

	public void setGeContractCode(String geContractCode) {
		this.geContractCode = geContractCode;
	}

	

	public String getIps() {
		return this.ips;
	}

	public void setIps(String ips) {
		this.ips = ips;
	}

	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getOrderSale() {
		return this.orderSale;
	}

	public void setOrderSale(String orderSale) {
		this.orderSale = orderSale;
	}

	public String getOrderSaleMargin() {
		return this.orderSaleMargin;
	}

	public void setOrderSaleMargin(String orderSaleMargin) {
		this.orderSaleMargin = orderSaleMargin;
	}



	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getSegment() {
		return this.segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

	public String getSubBusiness() {
		return this.subBusiness;
	}

	public void setSubBusiness(String subBusiness) {
		this.subBusiness = subBusiness;
	}

	public String getUnitCount() {
		return this.unitCount;
	}

	public void setUnitCount(String unitCount) {
		this.unitCount = unitCount;
	}

	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUsexportDomIntl() {
		return this.usexportDomIntl;
	}

	public void setUsexportDomIntl(String usexportDomIntl) {
		this.usexportDomIntl = usexportDomIntl;
	}


}