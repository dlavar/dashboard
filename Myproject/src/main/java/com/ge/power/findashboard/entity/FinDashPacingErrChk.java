package com.ge.power.findashboard.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the FIN_DASH_PACING_ERR_CHK database table.
 * 
 */
@Entity
@Table(name="FIN_DASH_PACING_ERR_CHK")
@NamedQuery(name="@GETERRORCHECKDETAILS",query="select e from FinDashPacingErrChk e where e.batchId=:batchId")
public class FinDashPacingErrChk implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="BATCH_ID")
	private Integer batchId;

	@Column(name="CNTRY_ERR_CHK")
	private BigDecimal cntryErrChk;

	@Column(name="COUNTRY_US_STATE")
	private String countryUsState;

	@Column(name="EQP_SRV_ERR_CHK")
	private BigDecimal eqpSrvErrChk;

	@Column(name="EQUIP_SERV")
	private String equipServ;
	
	@Id
	@Column(name="ERR_CHK_KEY")
	private BigDecimal errChkKey;

	@Column(name="EXT_ERR_CHK")
	private BigDecimal extErrChk;

	@Column(name="EXT_OGE_OI")
	private String extOgeOi;

	@Column(name="OI_O_MARGIN")
	private String oiOMargin;

	@Column(name="OI_O_MRGN_ERR_CHK")
	private BigDecimal oiOMrgnErrChk;

	@Column(name="PROJECT_NAME")
	private String projectName;

	@Column(name="SEG_ERR_CHK")
	private BigDecimal segErrChk;

	private String segment;

	public FinDashPacingErrChk() {
	}

	public Integer getBatchId() {
		return this.batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public BigDecimal getCntryErrChk() {
		return this.cntryErrChk;
	}

	public void setCntryErrChk(BigDecimal cntryErrChk) {
		this.cntryErrChk = cntryErrChk;
	}

	public String getCountryUsState() {
		return this.countryUsState;
	}

	public void setCountryUsState(String countryUsState) {
		this.countryUsState = countryUsState;
	}

	public BigDecimal getEqpSrvErrChk() {
		return this.eqpSrvErrChk;
	}

	public void setEqpSrvErrChk(BigDecimal eqpSrvErrChk) {
		this.eqpSrvErrChk = eqpSrvErrChk;
	}

	public String getEquipServ() {
		return this.equipServ;
	}

	public void setEquipServ(String equipServ) {
		this.equipServ = equipServ;
	}

	public BigDecimal getErrChkKey() {
		return this.errChkKey;
	}

	public void setErrChkKey(BigDecimal errChkKey) {
		this.errChkKey = errChkKey;
	}

	public BigDecimal getExtErrChk() {
		return this.extErrChk;
	}

	public void setExtErrChk(BigDecimal extErrChk) {
		this.extErrChk = extErrChk;
	}

	public String getExtOgeOi() {
		return this.extOgeOi;
	}

	public void setExtOgeOi(String extOgeOi) {
		this.extOgeOi = extOgeOi;
	}

	public String getOiOMargin() {
		return this.oiOMargin;
	}

	public void setOiOMargin(String oiOMargin) {
		this.oiOMargin = oiOMargin;
	}

	public BigDecimal getOiOMrgnErrChk() {
		return this.oiOMrgnErrChk;
	}

	public void setOiOMrgnErrChk(BigDecimal oiOMrgnErrChk) {
		this.oiOMrgnErrChk = oiOMrgnErrChk;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public BigDecimal getSegErrChk() {
		return this.segErrChk;
	}

	public void setSegErrChk(BigDecimal segErrChk) {
		this.segErrChk = segErrChk;
	}

	public String getSegment() {
		return this.segment;
	}

	public void setSegment(String segment) {
		this.segment = segment;
	}

}