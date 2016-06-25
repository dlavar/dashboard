package com.ge.power.findashboard.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ge.power.findashboard.entity.FinDashPacingErrChk;
import com.ge.power.findashboard.upload.abstractclasses.UploadTables;



@Service
public interface FileUploadServices {
	public Integer uploadFile(byte[] byteArray,UploadTables uploadTables) throws Exception;
	public List<String> getCountriesData();
	public List<FinDashPacingErrChk> getErrorCheckDetails(Integer batchId) throws Exception;
	
}
