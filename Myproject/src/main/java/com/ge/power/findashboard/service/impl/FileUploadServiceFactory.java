package com.ge.power.findashboard.service.impl;

import org.springframework.stereotype.Component;

import com.ge.power.findashboard.service.FileUploadServices;
import com.ge.power.findashboard.upload.abstractclasses.FileUploadConstants;
import com.ge.power.findashboard.upload.abstractclasses.UploadTables;

@Component
public class FileUploadServiceFactory {
	
	private FileUploadServices uploadServiceInstance;

	public FileUploadServices getUploadServiceInstance(UploadTables uploadTableParams) {
		if(FileUploadConstants.EXCEL_UPLOAD.equals(uploadTableParams.getUploadType())){
			uploadServiceInstance =new ExcelUploadService();
		}
		return uploadServiceInstance;
	}

	public void setUploadServiceInstance(FileUploadServices uploadServiceInstance) {
		this.uploadServiceInstance = uploadServiceInstance;
	}
	
	

}
