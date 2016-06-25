package com.ge.power.findashboard.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ge.power.findashboard.entity.FinDashPacing;
import com.ge.power.findashboard.upload.abstractclasses.FileUploadConstants;
import com.ge.power.findashboard.vo.ExportExcelVO;

@Component
public abstract class ExportFactory{
	ResourceBundle exportprops = ResourceBundle.getBundle("export");
	
	@Value("${export.file.fileName}")
	protected String fileName;
	
	@Value("${export.file.path}")	
	protected String filePath;
	
	
	protected String frizedCells;
	
	public abstract String export(List<ExportExcelVO> ExportData) throws Exception;
	
	protected List<String> getHeaders(){
		List<String> headers = new ArrayList<String>();
		StringTokenizer strtoken = new StringTokenizer(exportprops.getString("export.file.headers"),",");
		while(strtoken.hasMoreTokens()){
			headers.add(strtoken.nextToken());
		}
		for(String s:headers){
			System.out.println(s);
		}
		return headers;
	}
	protected String getTabOneName(){
		return exportprops.getString("export.excel.file.sheets");
	}
	protected String getFileName(){
		return new String().concat(filePath).concat(fileName).concat(".xls");
		}
	
	public List<ExportExcelVO> fillData(List<FinDashPacing> results){
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
	
	protected List<Integer> getFreezedColumnsList() throws Exception{
		
		frizedCells=exportprops.getString("export.file.freeZCellsIndex");
		StringTokenizer stokenizer = null;
		List<Integer> freezedCellsList = null;
		
		try{
			stokenizer = new StringTokenizer(frizedCells,FileUploadConstants.COMMA);
			if(stokenizer.countTokens()>0){
				freezedCellsList = new ArrayList<Integer>();
			}
			while(stokenizer.hasMoreTokens()){				
				String strTmp = stokenizer.nextToken();
				System.out.println("StrTmp::"+strTmp);
				if(strTmp.contains(FileUploadConstants.ELIPSE)){
					StringTokenizer localnum = new StringTokenizer(strTmp,FileUploadConstants.ELIPSE);
					String startIndex=localnum.nextToken();
					String endIndex = localnum.nextToken();
					int i=0;
					for(i=Integer.valueOf(startIndex);i<=Integer.valueOf(endIndex);i++){
						freezedCellsList.add(Integer.valueOf(i));						
					}
					
				}else{
					freezedCellsList.add(Integer.valueOf(strTmp));
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception ("File While Processing Export ...."+e.getMessage());
		}	
		
		return freezedCellsList;
	}
	
}
