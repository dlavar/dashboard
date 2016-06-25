package com.ge.power.findashboard.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the FIN_DASH_PACING database table.
 * 
 */
@Entity
@Cacheable
@Table(name="FIN_DASH_PACING")
@IdClass(FinDashPacingPK.class)
public class FinDashPacing implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="BATCH_ID")
	private String batchId;

	private String business;

	@Column(name="COUNTRY_OF_ORIGIN")
	private String countryOfOrigin;

	@Column(name="COUNTRY_US_STATE")
	private String countryUsState;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	private String customer;

	@Column(name="DR14B_COUNTRY")
	private String dr14bCountry;

	@Column(name="EQUIP_SERV")
	private String equipServ;

	@Column(name="EXT_OGE_OI")
	private String extOgeOi;

	@Column(name="GE_ALSTOM")
	private String geAlstom;

	@Column(name="GE_CONTRACT_CODE")
	private String geContractCode;

	@Column(name="GGO_COUNTRY")
	private String ggoCountry;

	@Column(name="GGO_SUB_REGION")
	private String ggoSubRegion;

	private String ips;

	private String model;

	@Column(name="ORDER_SALE")
	private String orderSale;

	@Column(name="ORDER_SALE_MARGIN")
	private String orderSaleMargin;

	@Column(name="ORDER_SALE_MARGIN_PCT")
	private String orderSaleMarginPct;
	
	@Id
	@Column(name="PROJECT_ID")
	private String projectId;

	@Column(name="PROJECT_NAME")
	private String projectName;

	private String quarter;

	@Column(name="SALE_OI")
	private String saleOi;

	private String segment;

	@Column(name="SUB_BUSINESS")
	private String subBusiness;

	@Column(name="UNIT_COUNT")
	private String unitCount;

	@Column(name="UPDATED_BY")
	private String updatedBy;

	@Temporal(TemporalType.DATE)
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	@Column(name="USEXPORT_DOM_INTL")
	private String usexportDomIntl;
	
	@Id
	@Column(name="VERSION_ID")
	private BigDecimal versionId;

	private String year;

	public FinDashPacing() {
	}

	public String getBatchId() {
		return this.batchId;
	}

	public void setBatchId(String batchId) {
		this.batchId = batchId;
	}

	public String getBusiness() {
		return this.business;
	}

	public void setBusiness(String business) {
		this.business = business;
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

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getDr14bCountry() {
		return this.dr14bCountry;
	}

	public void setDr14bCountry(String dr14bCountry) {
		this.dr14bCountry = dr14bCountry;
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

	public String getGeAlstom() {
		return this.geAlstom;
	}

	public void setGeAlstom(String geAlstom) {
		this.geAlstom = geAlstom;
	}

	public String getGeContractCode() {
		return this.geContractCode;
	}

	public void setGeContractCode(String geContractCode) {
		this.geContractCode = geContractCode;
	}

	public String getGgoCountry() {
		return this.ggoCountry;
	}

	public void setGgoCountry(String ggoCountry) {
		this.ggoCountry = ggoCountry;
	}

	public String getGgoSubRegion() {
		return this.ggoSubRegion;
	}

	public void setGgoSubRegion(String ggoSubRegion) {
		this.ggoSubRegion = ggoSubRegion;
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

	public String getOrderSaleMarginPct() {
		return this.orderSaleMarginPct;
	}

	public void setOrderSaleMarginPct(String orderSaleMarginPct) {
		this.orderSaleMarginPct = orderSaleMarginPct;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getQuarter() {
		return this.quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getSaleOi() {
		return this.saleOi;
	}

	public void setSaleOi(String saleOi) {
		this.saleOi = saleOi;
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

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUsexportDomIntl() {
		return this.usexportDomIntl;
	}

	public void setUsexportDomIntl(String usexportDomIntl) {
		this.usexportDomIntl = usexportDomIntl;
	}

	public BigDecimal getVersionId() {
		return this.versionId;
	}

	public void setVersionId(BigDecimal versionId) {
		this.versionId = versionId;
	}

	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}