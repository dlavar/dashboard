package com.ge.power.findashboard.upload.abstractclasses;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.stereotype.Component;

import com.ge.power.findashboard.service.FileUploadServices;
import com.ge.power.findashboard.service.impl.ExcelUploadService;


@Component
public abstract class UploadTables{
	
	protected List<String> allowedTypes = new ArrayList<String>();
	protected String primaryTable;
	protected String uploadType;
	protected List<String> columnsToInsertIntoTables;
	protected List<String> tablesNeedToUploadData;	
	protected Boolean uploadable;
	protected String entityPackage;
	protected Map<String,List<Object>> userInsertedColumnsforUploadTable;
	protected int numberofRows;
	
	
	
		
	
	public int getNumberofRows() {
		return numberofRows;
	}
	public void setNumberofRows(int numberofRows) {
		this.numberofRows = numberofRows;
	}
	public abstract Map<String,List<Object>> setupUserInsertedColumnsforUploadTable(UploadTables u);
	public void setUserInsertedColumns(Map<String,List<Object>> userInsertedableColumnsMap){
		this.userInsertedColumnsforUploadTable=userInsertedableColumnsMap;
	}
	public Map<String, List<Object>> getUserInsertedColumns() {
		return userInsertedColumnsforUploadTable;
	}
	 	
	protected void setEntityPackage(String entityPackage){
		this.entityPackage=entityPackage;
	}
	public String getEntityPackage(){
		return this.entityPackage;
	}
	
	public UploadTables(){
		setAllowedTypes();
	}
	
	protected void setColumnsToInsertIntoTables(String columns){		
		this.columnsToInsertIntoTables=convertStringToList(columns,FileUploadConstants.COMMA);
	}
	 

	public List<String> getAllowedTypes() {
		return allowedTypes;
	}
	public void setPrimaryTable(String primaryTable) {
		this.primaryTable = primaryTable;
	}
	
	public String getPrimaryTable() {
		return primaryTable;
	}

	public String getUploadType() {
		return uploadType;
	}

	public List<String> getColumnsToInsertIntoTables() {
		return columnsToInsertIntoTables;
	}

	public List<String> getSecondaryTables() {
		return tablesNeedToUploadData;
	}

	public Boolean getUploadable() {
		return uploadable;
	}

	

	
	
	
	
	public FileUploadServices getServiceInstance(){
		FileUploadServices serviceInstance=null;
		if (uploadable){
			if("EXCEL_UPLOAD".equalsIgnoreCase(uploadType)){
				serviceInstance=new ExcelUploadService();
			}
		}
		return serviceInstance;
	}

	
	
	protected Boolean setUploadType(String upLoadType){
	
		if(allowedTypes.contains(upLoadType.toUpperCase())){
			this.uploadType=upLoadType;
			uploadable=true;
		}
		return uploadable;
	}
	
	
	
	
	/*@SuppressWarnings("unchecked")
	public T getPrimaryTableInstance() throws InstantiationException, IllegalAccessException{
			return (T) primaryTable.getClass().newInstance();
	}*/
	
	
	private void setAllowedTypes(){
		allowedTypes.add("EXCEL_UPLOAD");
	}
	
	
	public abstract UploadTables setUpLoadParameters(InputStream is) throws Exception;
	
	private List<String> convertStringToList(String str,String delim){
		List<String> finalList = null;

		String tableName="";
		if(str.contains(FileUploadConstants.LEFT_PARANTHASYS)){
			this.tablesNeedToUploadData=new ArrayList<String>();
			tableName=str.substring(0,str.indexOf(FileUploadConstants.LEFT_PARANTHASYS));
			tablesNeedToUploadData.add(tableName);
			str=str.substring(str.indexOf(FileUploadConstants.LEFT_PARANTHASYS)+1,str.indexOf(FileUploadConstants.RIGHT_PARANTHASYS));
			System.out.print("columns"+str);
			
		}
		StringTokenizer stringTokenizer = new StringTokenizer(str, delim);
		if(stringTokenizer.countTokens()>0){
			finalList=new ArrayList<String>();
			int index=0;
			while(stringTokenizer.hasMoreTokens()){
				finalList.add(index,tableName+FileUploadConstants.DOT+stringTokenizer.nextToken());
				index++;
				
			}
		}
		return finalList;
	}
	
	/*public static void main(String args[]){
		String s = "A(B)";
		System.out.println(s.substring(s.indexOf(FileUploadConstants.LEFT_PARANTHASYS)+1,s.indexOf(FileUploadConstants.RIGHT_PARANTHASYS)));
	}*/
}
