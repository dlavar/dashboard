package com.ge.power.findashboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ge.power.findashboard.entity.FinDashBatchTracker;
import com.ge.power.findashboard.entity.FinDashPacingErrChk;

@Repository
public interface FileUploadDao {
	public Boolean uploadFileToTable(List<Object> uploadVo) throws Exception;
	public int getBatchId(FinDashBatchTracker batch) throws  Exception;
	public int getBatchIdfromSeq();
	public List<String> getCountryRegionList() throws Exception;
	public List<String> getCountryStateData() throws Exception;
	public Integer callErrorCheckProcedure(Integer batchId) throws Exception;
	public List<FinDashPacingErrChk> getErrorDetails(Integer batchId) throws Exception;
}
