package com.ge.power.findashboard.repositry;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.power.findashboard.dao.FileUploadDao;
import com.ge.power.findashboard.entity.FinDashBatchTracker;
import com.ge.power.findashboard.upload.abstractclasses.FileUploadConstants;
import com.ge.power.findashboard.upload.abstractclasses.UploadTables;

@Service
public class UploadFinDashBatchTracker extends UploadTables{
	
/*	GE/Alstom	Business	Segment	Order/ Sale/ OI	Equip/ Serv	GE contract code (Alstom only)	IPS	Customer	Project	Country/US State	
	Qtr	Model	 Unit Count 	 Order/ Sale $ 	 Order/ Sale Margin $ 	Order/ Sale Margin%	
	EXT/ OGE/ OI	Country of origin (Alstom only)	USExport/ USDomestic/ Intl	Sub Business	
	GGO Sub Region	GGO Country	USExport or USDomestic	Actuals Only: Intl Check*/
	
	@Autowired
	private FileUploadDao fileuploadDao;
	
	
	private int noofrow;
	private int loopValue;

	
	private static final String columns="FinDashPacingStg(segment,equipServ,"
			+ "geContractCode,ips,customer,projectName,countryUsState,model,"
			+ "unitCount,orderSale,orderSaleMargin,extOgeOi,countryOfOrigin,usexportDomIntl,"
			+ "subBusiness)";
	
	
	private UploadTables uploadTables;
	
	public UploadTables getUploadTables() {
		return uploadTables;
	}
	
	private String filename;

	public void setUploadTables(UploadTables uploadTables) throws IOException {
		this.uploadTables = setUpLoadParameters(new ByteArrayInputStream(filename.getBytes()));
	}


	public UploadFinDashBatchTracker(){
	super();
	}
	

	@Override
	public UploadTables setUpLoadParameters(InputStream is) throws IOException {
		
		XSSFWorkbook workbook = new XSSFWorkbook(is);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		
		
		UploadFinDashBatchTracker upLoadFinDashBatchTracker = new UploadFinDashBatchTracker();
		upLoadFinDashBatchTracker.setEntityPackage("com.ge.power.findashboard.entity");
		System.out.println("physical no of rows::"+sheet.getPhysicalNumberOfRows());
		noofrow = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(3);
		if(row!=null && row.getPhysicalNumberOfCells()>14){
			loopValue=noofrow-FileUploadConstants.modifyFileload;
		}else{
			loopValue=noofrow-FileUploadConstants.templateUpload;
		}
		upLoadFinDashBatchTracker.setNumberofRows(noofrow);
		/*upLoadFinDashBatchTracker.setPrimaryTable("FinDashBatchTracker");*/
		if(upLoadFinDashBatchTracker.setUploadType("EXCEL_UPLOAD"));
		{
			upLoadFinDashBatchTracker.setColumnsToInsertIntoTables(columns);

		}
		upLoadFinDashBatchTracker.setUserInsertedColumns(setupUserInsertedColumnsforUploadTable(upLoadFinDashBatchTracker));
		return upLoadFinDashBatchTracker;
		
	}


	@Override
	public Map<String, List<Object>> setupUserInsertedColumnsforUploadTable(UploadTables upLoadFinDashBatchTracker) {
		Map<String,List<Object>> userInsertableValues=null;
		
		try{
			FinDashBatchTracker findashBatchTracker = new FinDashBatchTracker();
			findashBatchTracker.setStatus("U");
			findashBatchTracker.setCreatedBy("Application");
			//int batchId = fileuploadDao.getBatchId(findashBatchTracker);
			String createdDate=DatetoString(Calendar.getInstance().getTime());
			/*List<Object>batchidList = new ArrayList<Object>();*/
			/*batchidList.add(String.valueOf(batchId));
			batchidList.add(String.valueOf(batchId));*/
			List<Object>createdDateList = new ArrayList<Object>();
			/*createdDateList.add("DATE "+createdDate);
			createdDateList.add("DATE "+createdDate);*/
			String createdBy = "Application";
			List<Object>createdByList = new ArrayList<Object>();
			System.out.println("noofrow:"+noofrow);			
			createdByList=addtoList(createdByList,createdBy,loopValue);
			String upDatedDate=DatetoString(Calendar.getInstance().getTime());
			List<Object>updatedDateList = new ArrayList<Object>();
			/*updatedDateList.add("DATE "+upDatedDate);
			updatedDateList.add("DATE "+upDatedDate);*/
			String upDatedBy = "Application";
			List<Object>UpdatedByList = new ArrayList<Object>();
			UpdatedByList=addtoList(UpdatedByList,upDatedBy,loopValue);
			userInsertableValues=new HashMap<String,List<Object>>();
			//userInsertableValues.put("createdDate", createdDateList);
			userInsertableValues.put("createdBy", createdByList);
			userInsertableValues.put("updatedBy", UpdatedByList);
		/*	userInsertableValues.put("batchId", batchidList);*/
			//userInsertableValues.put("updatedDate", updatedDateList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return userInsertableValues;
	}
	private String DatetoString(Date d){
		d = Calendar.getInstance().getTime();
		SimpleDateFormat stf= new SimpleDateFormat("yyyy-dd-MM");
		return stf.format(d);
	}

	@SuppressWarnings("unchecked")
	private List<Object> addtoList(List list,String s,int noOfRows){
		for(int i=0;i<noOfRows;i++){
			list.add(s);
		}
		return list;
	}

	
	
	

}
