package com.ge.power.findashboard.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;

public class FindashClosingFinancialsRawPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name="C_YEAR")
	private BigDecimal cYear;
	
	@Column(name="QUARTER")
	private String quarter;
	
	@Column(name="SECTION")
	private String section;

	public BigDecimal getcYear() {
		return cYear;
	}

	public void setcYear(BigDecimal cYear) {
		this.cYear = cYear;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cYear == null) ? 0 : cYear.hashCode());
		result = prime * result + ((quarter == null) ? 0 : quarter.hashCode());
		result = prime * result + ((section == null) ? 0 : section.hashCode());
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
		FindashClosingFinancialsRawPK other = (FindashClosingFinancialsRawPK) obj;
		if (cYear == null) {
			if (other.cYear != null)
				return false;
		} else if (!cYear.equals(other.cYear))
			return false;
		if (quarter == null) {
			if (other.quarter != null)
				return false;
		} else if (!quarter.equals(other.quarter))
			return false;
		if (section == null) {
			if (other.section != null)
				return false;
		} else if (!section.equals(other.section))
			return false;
		return true;
	}
	
	
	
}
