package com.ge.power.findashboard.dao.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.ge.power.findashboard.constants.FinDashBoardFileUploadConstants;
import com.ge.power.findashboard.dao.FileUploadDao;


public class FinDashFileUploadValidationsimpl implements FileUploadCommonValidations {
	
@Autowired
private  FileUploadDao fileuploadDao;

public  Boolean validateFile(byte[] byteArray,List<String> countriesList) throws IOException{
	boolean isValid=false;
	System.out.println("FinDashFileUpload----size");
	XSSFWorkbook workbook = new XSSFWorkbook(new ByteArrayInputStream(byteArray));
	XSSFSheet sheet = workbook.getSheetAt(0);
	try{
		Iterator<Row> rows = sheet.rowIterator();
		while(rows.hasNext()){
			Row row = rows.next();	
			if(row.getRowNum()<4) {continue;}
			isValid = validateSegmentforRow(row,Integer.parseInt(FinDashBoardFileUploadConstants.segmentCellIndex));
			isValid = validateEXT(row,Integer.parseInt(FinDashBoardFileUploadConstants.EXTOGEOIINDEX));
			isValid = validateEquip(row,Integer.parseInt(FinDashBoardFileUploadConstants.EquipIndex));
			isValid = validateSalesOI(row,Integer.parseInt(FinDashBoardFileUploadConstants.SALESOIINDEX),Integer.parseInt(FinDashBoardFileUploadConstants.MarginIndex));
			isValid = validCountryState(row,Integer.parseInt(FinDashBoardFileUploadConstants.CountryStateIndex),countriesList);
			
		}
	
	}catch(Exception e){
		e.printStackTrace();
		
	}
	return isValid;
}
private  boolean validateSegmentforRow(Row row,int index) throws Exception{
	Boolean valid=false;
	try{
		String validSegmentValues[]=FinDashBoardFileUploadConstants.validSegmentValues;
		Cell cell = row.getCell(index);
		for(String segmentVal:validSegmentValues){
			if(cell!=null){
				if(segmentVal.equalsIgnoreCase(cell.getStringCellValue())){
					valid=true;
					break;
				}
					
				}
			}
		if(!valid){
			throw new Exception (FinDashBoardFileUploadConstants.SEGMENT_NOT_IN_GIVEN_VALUES +" @ "+((row.getRowNum()+1)));
		}
	
	}catch(Exception e){
		e.printStackTrace();
		throw new Exception("Failed While Validating Segment");
	}
	return valid;
}

private  boolean validateEXT(Row row,int index) throws Exception{
	Boolean valid=false;
	try{
		String validValues[]=FinDashBoardFileUploadConstants.validEXTGEOOIValues;
		Cell cell = row.getCell(index);
		for(String val:validValues){
			if(cell!=null){
				if(val.equalsIgnoreCase(cell.getStringCellValue())){
					valid=true;
					break;
				}
			}
		}
		if(!valid){
			throw new Exception (FinDashBoardFileUploadConstants.EXTOGEOINOTINGIVENVALUES +" @ "+((row.getRowNum()+1)));
		}
	}catch(Exception e){
		e.printStackTrace();
		throw new Exception("Failed While Validating EXTGEO");
	}
	return valid;
}

private  boolean validateEquip(Row row,int index) throws Exception{
	Boolean valid=false;
	try{
		String validValues[]=FinDashBoardFileUploadConstants.EQUIValues;
		Cell cell = row.getCell(index);
		for(String val:validValues){
			if(cell!=null){
				if(val.equalsIgnoreCase(cell.getStringCellValue())){
					valid=true;
					break;
				}
			}
		}
		if(!valid){
			throw new Exception (FinDashBoardFileUploadConstants.EQUIPValuesNotValid +" @ "+(row.getRowNum()+1));
		}
	}catch(Exception e){
		e.printStackTrace();
		throw new Exception("Failed While Validating EQUIP");
	}
	return valid;
}
private  boolean validateSalesOI(Row row,int salesindex,int marginindex) throws Exception{
	Boolean valid=false;
	try{
		
		Cell cell = row.getCell(salesindex);
		if(FinDashBoardFileUploadConstants.SALES.equalsIgnoreCase(cell.getStringCellValue())){
			valid=true;
		}else if(FinDashBoardFileUploadConstants.OI.equalsIgnoreCase(cell.getStringCellValue())){
			cell = row.getCell(marginindex);
			if(cell.getNumericCellValue()==0){
				valid=true;
			}else{
				throw new Exception (FinDashBoardFileUploadConstants.SalesMarginError+" @ "+(row.getRowNum()+1));
			}
		}
	}catch(Exception e){
		e.printStackTrace();
		throw new Exception("Failed While Validating SalesOI");
	}
	return valid;
}

private  boolean validCountryState(Row row,int index,List<String>countriesList) throws Exception{
	Boolean valid=false;
	try{
		
		Cell cell = row.getCell(index);
		if(countriesList.contains(String.valueOf(cell.getStringCellValue()))){
			valid = true;
		}else{
			throw new Exception (FinDashBoardFileUploadConstants.countryNotinlistError+" @ "+(row.getRowNum()+1));
		}
		
		
	}catch(Exception e){
		e.printStackTrace();
		throw new Exception("Failed While Validating CountryState");
	}
	return valid;
}

}
