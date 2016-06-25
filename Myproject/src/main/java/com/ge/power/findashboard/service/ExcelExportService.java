package com.ge.power.findashboard.service;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.ge.power.findashboard.factory.ExportFactory;
import com.ge.power.findashboard.vo.ExportExcelVO;

@Service
public class ExcelExportService extends ExportFactory{

	@Override
	public String export(List<ExportExcelVO>exportData) throws Exception {
		List<String> headers = getHeaders();
		XSSFWorkbook excelWorkbook = new XSSFWorkbook();
		List<Integer> freezedCells = getFreezedColumnsList();
		int colNum=0;
	    // Aqua background
		CellStyle editableCol = excelWorkbook.createCellStyle();
		editableCol.setFillBackgroundColor(IndexedColors.RED.getIndex());
		editableCol.setFillPattern(CellStyle.BIG_SPOTS);
		
        // Orange "foreground", foreground being the fill foreground not the font color.
		editableCol.setFillForegroundColor(IndexedColors.RED.getIndex());
		editableCol.setFillPattern(CellStyle.SOLID_FOREGROUND);
		Font font = excelWorkbook.createFont();
	    font.setFontHeightInPoints((short)10);
	    font.setFontName("GE Inspira");
	    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
	    font.setColor(IndexedColors.WHITE.getIndex());
	    editableCol.setFont(font);
	    
	    
	    CellStyle noneditableCol = excelWorkbook.createCellStyle();
	    noneditableCol.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
	    noneditableCol.setFillPattern(CellStyle.BIG_SPOTS);
		
        // Orange "foreground", foreground being the fill foreground not the font color.
		noneditableCol.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		noneditableCol.setFillPattern(CellStyle.SOLID_FOREGROUND);
		font = excelWorkbook.createFont();
	    font.setFontHeightInPoints((short)10);
	    font.setFontName("GE Inspira");
	    font.setBoldweight(Font.BOLDWEIGHT_BOLD);
	    font.setColor(IndexedColors.WHITE.getIndex());
	    noneditableCol.setFont(font);
	    
	    
        //style.setWrapText(true);
        
        CellStyle style_data = excelWorkbook.createCellStyle();
	    Font font_data = excelWorkbook.createFont();
	    font_data.setFontHeightInPoints((short)10);
	    font_data.setFontName("GE Inspira");
	    
	    //For editable fields
	    
	    CellStyle unlockedCells = excelWorkbook.createCellStyle();
		font_data = excelWorkbook.createFont();
		font_data.setFontHeightInPoints((short)10);
		font_data.setFontName("GE Inspira");
		unlockedCells.setLocked(false);
	    
	    
	  
		XSSFSheet sheet= excelWorkbook.createSheet(getTabOneName());
		Row headerRow = sheet.createRow(3);
		
		for(String cellHeading : headers ){
			Cell cell=	headerRow.createCell(colNum++);
			if(colNum>15){
				cell.setCellStyle(noneditableCol);
			}else{cell.setCellStyle(editableCol);}
			cell.setCellValue(cellHeading);
		}
		sheet=fillSheetData(exportData,sheet,style_data,unlockedCells,freezedCells);
		
		sheet.protectSheet("password");
		
		FileOutputStream file = new FileOutputStream(new File(getFileName()));
		excelWorkbook.write(file);		
		file.close();
		return getFileName();
	}
	private XSSFSheet fillSheetData(List<ExportExcelVO> exportData,XSSFSheet sheet,CellStyle style_data,CellStyle unlockedCellsStyle,List<Integer> freezedCells) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		int headerrownum=3;
		for(ExportExcelVO row:exportData){
			Row excelRow = sheet.createRow(++headerrownum);
			for(int i=0;i<24;i++){				
				Method method=ExportExcelVO.class.getMethod("getCell_"+i);
				String cellValue=(String)method.invoke(row);
				Cell cell=	excelRow.createCell(i);
				cell.setCellValue(cellValue);	
				if(freezedCells!=null&&!freezedCells.isEmpty()){
					if(freezedCells.contains(Integer.valueOf(i))){
						style_data.setLocked(true);
						cell.setCellStyle(style_data);
					}else{					  
						    cell.setCellStyle(unlockedCellsStyle);
					}
				}
				
			}
		}
		return sheet;
	}
	
	
	
}
