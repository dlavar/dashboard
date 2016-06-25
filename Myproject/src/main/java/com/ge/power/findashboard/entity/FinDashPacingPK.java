package com.ge.power.findashboard.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class FinDashPacingPK implements Serializable{
	private String projectId;
	private BigDecimal versionId;
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public BigDecimal getVersionId() {
		return versionId;
	}
	public void setVersionId(BigDecimal versionId) {
		this.versionId = versionId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((projectId == null) ? 0 : projectId.hashCode());
		result = prime * result
				+ ((versionId == null) ? 0 : versionId.hashCode());
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
		FinDashPacingPK other = (FinDashPacingPK) obj;
		if (projectId == null) {
			if (other.projectId != null)
				return false;
		} else if (!projectId.equals(other.projectId))
			return false;
		if (versionId == null) {
			if (other.versionId != null)
				return false;
		} else if (!versionId.equals(other.versionId))
			return false;
		return true;
	}
	
	
}
