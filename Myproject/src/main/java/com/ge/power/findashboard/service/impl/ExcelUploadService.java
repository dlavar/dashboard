package com.ge.power.findashboard.service.impl;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.power.findashboard.dao.FileUploadDao;
import com.ge.power.findashboard.entity.FinDashBatchTracker;
import com.ge.power.findashboard.entity.FinDashPacingErrChk;
import com.ge.power.findashboard.service.FileUploadServices;
import com.ge.power.findashboard.upload.abstractclasses.FileUploadConstants;
import com.ge.power.findashboard.upload.abstractclasses.UploadTables;

@Service
public class ExcelUploadService implements FileUploadServices{

	private static final Logger logger = Logger.getLogger(ExcelUploadService.class);
	
	@Autowired	
	private FileUploadDao fileUploadDao;
	
	
	@Override
	public Integer uploadFile(byte[] byteArray,UploadTables uploadTables) throws Exception{
		Integer uploadFlag=-1;
		
		try{
		
		//Create a Work BOOK;
		
		Object secondaryTable = null;
		List<String> secondaryTables = uploadTables.getSecondaryTables();
		List<String> columnsToInsert = uploadTables.getColumnsToInsertIntoTables();
		String pkg=uploadTables.getEntityPackage();
		/*Object primaryTable=null;Class.forName(pkg+FileUploadConstants.DOT+uploadTables.getPrimaryTable()).newInstance();*/
		List<Object> recordstopersists = new ArrayList<Object>();
	//	List<Object> secondaryTablesList = new ArrayList<Object>();
		
		
		XSSFWorkbook workbook = new XSSFWorkbook(new ByteArrayInputStream(byteArray));
		XSSFSheet sheet = workbook.getSheetAt(0);		
		Iterator<Row> rowIterator = sheet.iterator();
		Boolean validExcelFile=isValid(workbook);
		if(!validExcelFile){
			return -2;
		}

		FinDashBatchTracker finTracker = new FinDashBatchTracker();
		int batchId = fileUploadDao.getBatchIdfromSeq();
		finTracker.setStatus("UPLOADED");
		finTracker.setStatusCode("U");
		finTracker.setUpdatedBy("Application");
		finTracker.setCreatedBy("Application");
		finTracker.setBatchId(batchId);
		fileUploadDao.getBatchId(finTracker);
		
		
		while(rowIterator.hasNext()){
	
			Row row = rowIterator.next();
			
			logger.info("getRowNoiw"+row.getRowNum());
			if(row.getRowNum()<4){continue;}
			
			Iterator<Cell> cells = row.iterator(); 			
			int index=0;
			while(cells.hasNext()){
				
				Cell cell = cells.next();
				if(index>14){continue;}
				if(columnsToInsert.get(index).contains(FileUploadConstants.DOT)){
					String className=columnsToInsert.get(index).substring(0, columnsToInsert.get(index).indexOf(FileUploadConstants.DOT));
					Class tableClass=Class.forName(pkg+FileUploadConstants.DOT+className);
					if(secondaryTable==null){
						secondaryTable=tableClass.newInstance();
					}
					
						Field field=secondaryTable.getClass().getDeclaredField(
								columnsToInsert.get(index).substring(columnsToInsert.get(index).indexOf(FileUploadConstants.DOT)+1,columnsToInsert.get(index).length())
								);
						field.setAccessible(true);
						switch(cell.getCellType()){
						case Cell.CELL_TYPE_NUMERIC:
						field.set(secondaryTable, String.valueOf(cell.getNumericCellValue()));
								break;
						case Cell.CELL_TYPE_STRING:
								field.set(secondaryTable, cell.getStringCellValue());
								break;
						}
						
					}
		
		++index;	
		
		}
			
			secondaryTable=setUserInsertableValues(secondaryTable,uploadTables,String.valueOf(batchId));
			recordstopersists.add(secondaryTable);
	
		secondaryTable=null;
		}	
		
		Boolean f=fileUploadDao.uploadFileToTable(recordstopersists);
		if(f){
			Integer flag = fileUploadDao.callErrorCheckProcedure(batchId);
			if(flag==1){
				uploadFlag=batchId;				
			}
		}
		}catch(Exception e){
			uploadFlag=-1;
			logger.error(new Exception ("Upload Failed while setting values for inserting for tables"));
			e.printStackTrace();
			throw new Exception ("Upload Failed while setting values for inserting for tables");
		}
		//fileUploadDao.uploadFileToTable(secondaryTablesList);
		return uploadFlag;
}
	private Object setUserInsertableValues(Object tableName,UploadTables uploadTables,String batchId) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
			Map<String,List<Object>> userInsertedValues=uploadTables.getUserInsertedColumns();
			if(userInsertedValues!=null&&!userInsertedValues.isEmpty()){
				Set<String> columns = userInsertedValues.keySet();
				for(String col:columns){					
					List<Object> values = userInsertedValues.get(col);
					for(Object val:values){
						Field field1=tableName.getClass().getDeclaredField("batchId");
						field1.setAccessible(true);
						field1.set(tableName, batchId);
						Field field=tableName.getClass().getDeclaredField(col);
						field.setAccessible(true);
						if(val instanceof java.util.Date){
							field.set(tableName, (Date)val);
						}else{
							field.set(tableName, val);
						}
						
					}
				}
			}
			
			return tableName;
	}
	@Override
	public List<String> getCountriesData() {
		List<String> countries = null;
		try{
			countries=fileUploadDao.getCountryStateData();
		}catch(Exception e){
			e.printStackTrace();
		}
		return countries;
	}
	@Override
	public List getErrorCheckDetails(Integer batchId) throws Exception {
		List<FinDashPacingErrChk> errocheckdetails = null;
		try{
			errocheckdetails=fileUploadDao.getErrorDetails(batchId);
		}catch(Exception e){
			e.printStackTrace();
		}
		return errocheckdetails;
	}
	private Boolean isValid(XSSFWorkbook workbook){
		Boolean flag = false;
		try{
			XSSFSheet sheet = workbook.getSheetAt(0);
			XSSFRow row = sheet.getRow(3);
			int i=row.getPhysicalNumberOfCells();
			logger.info("i::"+i);
			if(row!=null && (row.getPhysicalNumberOfCells()==FileUploadConstants.standardUploadColumnNumber||row.getPhysicalNumberOfCells()==FileUploadConstants.ModifiedUploadColumnNumber)){
				flag=true;
			}
			
		}catch(Exception e){
			
		}
		return flag;
	}
}
