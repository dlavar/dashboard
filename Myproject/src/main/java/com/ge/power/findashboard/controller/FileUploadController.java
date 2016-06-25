package com.ge.power.findashboard.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ge.power.findashboard.repositry.UploadFinDashBatchTracker;
import com.ge.power.findashboard.service.FileUploadServices;
import com.ge.power.findashboard.service.impl.FileUploadServiceFactory;
import com.ge.power.findashboard.upload.abstractclasses.UploadTables;

@RestController
@RequestMapping("/services/uploadservices")
public class FileUploadController {	
	
	@Autowired
	private FileUploadServices fileUploadService; 
	
	@Autowired
	private FileUploadServiceFactory serviceFactory;
	

	
	@RequestMapping("/uploadfile")
	@POST
	public Integer uploadFile(@FormParam("choosefile") MultipartFile file,@FormParam("filename") String filename1) throws Exception{
		//filename=fileName;		
		int flag=-1;
		byte[] byteArray=file.getBytes();		
		InputStream is = new ByteArrayInputStream(byteArray);		
		UploadTables uploadTables=null;
		try{
		uploadTables=new UploadFinDashBatchTracker().setUpLoadParameters(is);		
		flag = fileUploadService.uploadFile(byteArray,uploadTables);		
		}catch(Exception e){
			flag=-1;
			e.printStackTrace();
			throw new Exception("File Upload Failed");
		}
		return flag;
		
		
	}
	@RequestMapping("/getErrorDetails")
	@GET
	public List getErrorDetails(@QueryParam("batchId") String batchId) throws Exception{
		Integer ibatchId = null;
		List errocheckList = null; 
		try{
			if(batchId!=null &&! "".equals(batchId)){
				ibatchId = Integer.valueOf(batchId);
				errocheckList=(List)fileUploadService.getErrorCheckDetails(ibatchId);			
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception ("Failed while getting the Error Details");
		}
		
		
		return errocheckList;
		
		
	}

}
