package com.ge.power.findashboard.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Id;

public class FindashClosingFinancialsAggPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	@Column(name="C_YEAR")
	private Long cYear;
	
	@Column(name="QUARTER")
	private String quarter;
	
	
	
	private String kpi;
	
	
	

	

	public String getKpi() {
		return kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
	}

	public Long getcYear() {
		return cYear;
	}

	public void setcYear(Long cYear) {
		this.cYear = cYear;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cYear == null) ? 0 : cYear.hashCode());
		result = prime * result + ((kpi == null) ? 0 : kpi.hashCode());
		result = prime * result + ((quarter == null) ? 0 : quarter.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FindashClosingFinancialsAggPK other = (FindashClosingFinancialsAggPK) obj;
		if (cYear == null) {
			if (other.cYear != null)
				return false;
		} else if (!cYear.equals(other.cYear))
			return false;
		if (kpi == null) {
			if (other.kpi != null)
				return false;
		} else if (!kpi.equals(other.kpi))
			return false;
		if (quarter == null) {
			if (other.quarter != null)
				return false;
		} else if (!quarter.equals(other.quarter))
			return false;
		return true;
	}
	
	
}
