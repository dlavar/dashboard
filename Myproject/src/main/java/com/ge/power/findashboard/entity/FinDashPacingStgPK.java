package com.ge.power.findashboard.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the FIN_DASH_PACING_STG database table.
 * 
 */
@Embeddable
public class FinDashPacingStgPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="PROJECT_ID")
	private long projectId;

	@Column(name="VERSION_ID")
	private long versionId;

	public FinDashPacingStgPK() {
		setProjectId(0);
		setVersionId(0);
	}
	public long getProjectId() {
		return this.projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = System.currentTimeMillis()+System.nanoTime();
	}
	public long getVersionId() {
		return this.versionId;
	}
	public void setVersionId(long versionId) {
		this.versionId = System.currentTimeMillis();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (projectId ^ (projectId >>> 32));
		result = prime * result + (int) (versionId ^ (versionId >>> 32));
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
		FinDashPacingStgPK other = (FinDashPacingStgPK) obj;
		if (projectId != other.projectId)
			return false;
		if (versionId != other.versionId)
			return false;
		return true;
	}

	

	
}