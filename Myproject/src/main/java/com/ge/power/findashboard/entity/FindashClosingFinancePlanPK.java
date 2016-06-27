package com.ge.power.findashboard.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;

public class FindashClosingFinancePlanPK implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name="R_QUARTER")
	private String rQuarter;

	@Column(name="R_YEAR")
	private BigDecimal rYear;

	public String getrQuarter() {
		return rQuarter;
	}

	public void setrQuarter(String rQuarter) {
		this.rQuarter = rQuarter;
	}

	public BigDecimal getrYear() {
		return rYear;
	}

	public void setrYear(BigDecimal rYear) {
		this.rYear = rYear;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rQuarter == null) ? 0 : rQuarter.hashCode());
		result = prime * result + ((rYear == null) ? 0 : rYear.hashCode());
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
		FindashClosingFinancePlanPK other = (FindashClosingFinancePlanPK) obj;
		if (rQuarter == null) {
			if (other.rQuarter != null)
				return false;
		} else if (!rQuarter.equals(other.rQuarter))
			return false;
		if (rYear == null) {
			if (other.rYear != null)
				return false;
		} else if (!rYear.equals(other.rYear))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
