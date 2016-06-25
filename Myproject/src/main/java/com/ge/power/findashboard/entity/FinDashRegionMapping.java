package com.ge.power.findashboard.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the FIN_DASH_REGION_MAPPING database table.
 * 
 */
@Entity
@Table(name="FIN_DASH_REGION_MAPPING")
@NamedQuery(name="@CountryState", query="select c.countryState from FinDashRegionMapping c")
public class FinDashRegionMapping implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="COUNTRY_STATE")
	private String countryState;

	@Column(name="CREATED_BY")
	private String createdBy;

	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;

	@Column(name="DR14B_COUNTRY")
	private String dr14bCountry;

	@Column(name="GGO_COUNTRY")
	private String ggoCountry;

	@Column(name="GGO_SUB_REGIONS")
	private String ggoSubRegions;

	public FinDashRegionMapping() {
	}

	public String getCountryState() {
		return this.countryState;
	}

	public void setCountryState(String countryState) {
		this.countryState = countryState;
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

	public String getDr14bCountry() {
		return this.dr14bCountry;
	}

	public void setDr14bCountry(String dr14bCountry) {
		this.dr14bCountry = dr14bCountry;
	}

	public String getGgoCountry() {
		return this.ggoCountry;
	}

	public void setGgoCountry(String ggoCountry) {
		this.ggoCountry = ggoCountry;
	}

	public String getGgoSubRegions() {
		return this.ggoSubRegions;
	}

	public void setGgoSubRegions(String ggoSubRegions) {
		this.ggoSubRegions = ggoSubRegions;
	}

}