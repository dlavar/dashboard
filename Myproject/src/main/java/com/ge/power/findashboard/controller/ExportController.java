package com.ge.power.findashboard.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ge.power.findashboard.dao.impl.FinanceSearchDAO;
import com.ge.power.findashboard.entity.FinDashPacing;
import com.ge.power.findashboard.factory.ExportFactory;
import com.ge.power.findashboard.vo.ExportExcelVO;
import com.ge.power.findashboard.vo.SearchCriteriaDataVO;

@RestController
@RequestMapping("/services/exportService")

public class ExportController {

@Autowired
private ExportFactory exportFactory;

@Autowired
private FinanceSearchDAO finsearchDao;

@Value("${import.file.fileName}")
private String standardTemplateFileName;


@Autowired
private ResourceLoader resourceLoader;

@RequestMapping("/dataExport")
@POST
public void exportData(HttpServletResponse response,@RequestParam(value="business",required=false) String strBusiness,@RequestParam(value="equipserv",required=false) String strEquipServ,
		@RequestParam(value="countrystate",required=false) String strcountryState,@RequestParam(value="quater",required=false) String strQuater,@RequestParam(value="year",required=false) String strYear){
	String fileName=null;
    InputStream is = null;
    response.setHeader("Content-disposition", "attachment;filename=FinanceDashBoard.xls");
    response.setContentType("application/vnd.ms-excel");
	
	SearchCriteriaDataVO searchVO = null;
	try{
		SearchCriteriaDataVO searchCriteria=new SearchCriteriaDataVO(strBusiness,strEquipServ,strcountryState,strQuater,strYear);
		List<FinDashPacing> data = finsearchDao.retrieveSearchResults(searchCriteria);
		List<ExportExcelVO> exportData = fillData(data);
		 fileName= exportFactory.export(exportData);
		  is=new FileInputStream(fileName);
	      org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
	      response.flushBuffer();
		
	}catch(Exception e){
		e.printStackTrace();
	}
		//return fileName;
	}
private List<ExportExcelVO> fillData(List<FinDashPacing> results){
	List<ExportExcelVO> exportData=null;
	if(results!=null && !results.isEmpty()){
		exportData=new ArrayList<ExportExcelVO>();
		for(FinDashPacing data : results){
			ExportExcelVO record= new ExportExcelVO(data);
			exportData.add(record);
		}
	}
	
	return exportData;
}

@RequestMapping("/dataImport")
@POST
public void importData(HttpServletResponse response){
	InputStream is = null;
	response.setHeader("Content-disposition", "attachment;filename="+standardTemplateFileName);
    response.setContentType("application/vnd.ms-excel");
	try{
		
			Resource resource = resourceLoader.getResource("classpath:"+standardTemplateFileName);
			is=resource.getInputStream();
			
			org.apache.commons.io.IOUtils.copy(is, response.getOutputStream());
		 
			response.flushBuffer();
		
	}catch(Exception e){
		e.printStackTrace();
	}finally
	{
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}

@RequestMapping("/dataUpload")
@POST
public String handleFileUpload(
		   @RequestParam("file") File file
		   ) {
	
	System.out.println(file.getAbsolutePath());
	return "Success fully Uploaded";
}


}
