package com.ge.power.findashboard.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ge.power.findashboard.dao.impl.FinanceSearchDAO;
import com.ge.power.findashboard.factory.ExportFactory;
import com.ge.power.findashboard.vo.PacingMasterVO;
import com.ge.power.findashboard.vo.SearchCriteriaDataVO;

@RestController
public class FinanceAppSearchController {
	
	@Autowired
	private FinanceSearchDAO financeSearchDAO;
	
	
	@Autowired
	private ExportFactory exportFactory;
	
	
	private static final Logger logger = Logger.getLogger(FinanceAppSearchController.class);
		
	@RequestMapping("/search")	
	@POST
	@Produces(MediaType.APPLICATION_JSON_VALUE)	
	public List getSearchResults(@RequestParam(value="business",required=false) String strBusiness,@RequestParam(value="equipserv",required=false) String strEquipServ,
			@RequestParam(value="countrystate",required=false) String strcountryState,@RequestParam(value="quater",required=false) String strQuater,@RequestParam(value="year",required=false) String strYear) throws Exception
	{
		
		logger.info("Form Params::business:"+strBusiness+":equServ::"+strEquipServ+":countryorstate::"+strcountryState+":quater::"+strQuater+":Year::::::"+strYear);
		SearchCriteriaDataVO searchCriteria=new SearchCriteriaDataVO(strBusiness,strEquipServ,strcountryState,strQuater,strYear);		
		logger.info("SearchCriteria"+searchCriteria);
		List result = financeSearchDAO.retrieveSearchResults(searchCriteria);
		@SuppressWarnings("unchecked")
		List datatoExport = exportFactory.fillData(result);
		String filename = exportFactory.export(datatoExport)+System.currentTimeMillis();
		return result;
	}
	
	@RequestMapping("/pacingmData")	
	@POST
	@Produces(MediaType.APPLICATION_JSON_VALUE)	
	public PacingMasterVO getPassingMasterData() throws Exception
	{	
		List<String> listBusiness=new ArrayList<String>();
	
		PacingMasterVO pacingMasterData = new PacingMasterVO();
		listBusiness.add("Test1");
		listBusiness.add("Test1");
		listBusiness.add("Test1");
		pacingMasterData.setBusiness(listBusiness);
		return pacingMasterData;
	}
	@RequestMapping(value="/uploadfile")
	@Consumes("multipart/form-data")
	@PUT
	public Boolean uploadFile(@RequestParam("filename") String filename) throws Exception{
		//filename=fileName;
		Boolean flag=true;
		//UploadTables uploadTables=null;
		try{
		//uploadTables=new UploadFinDashBatchTracker().setUpLoadParameters(filename);
		//List<String> CountryStateList = fileUploadService.getCountriesData();
		//flag = (new FinDashFileUploadValidationsimpl()).validateFile(filename,CountryStateList);
		if(flag){
		///	flag = fileUploadService.uploadFile(filename,uploadTables);
			
		}
		}catch(Exception e){
			flag=false;
			e.printStackTrace();
			throw new Exception("File Upload Failed");
		}
		return flag;
	}

}
