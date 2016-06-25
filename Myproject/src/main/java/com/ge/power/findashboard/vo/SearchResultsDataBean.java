/*
 * Author: Uday Kasturi(212468348)
 */
package com.ge.power.findashboard.vo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchResultsDataBean {
	private String geAlstom;
	private String business;
	private String segment;
	private String order_sale_oi;
	private String equip_serv;
	private String geContractCode;
	private String ips;
	private String customer;
	private String project;
	private String country_state;
	private String quater;
	private String model;
	private String unitcount;
	private String orderSalesAmount;
	private String orderSalesMargin;
	private String orderSalesMarginper;
	private String ext_oge_oi;
	private String countryRegion;
	private String usexport;
	private String subBusiness;
	private String ggoSubRegion;
	private String ggoCountry;
	private String usexp_dom;
	private String actuals;
	public String getGeAlstom() {
		return geAlstom;
	}
	public void setGeAlstom(String geAlstom) {
		this.geAlstom = geAlstom;
	}
	public String getBusiness() {
		return business;
	}
	public void setBusiness(String business) {
		this.business = business;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}
	public String getOrder_sale_oi() {
		return order_sale_oi;
	}
	public void setOrder_sale_oi(String order_sale_oi) {
		this.order_sale_oi = order_sale_oi;
	}
	public String getEquip_serv() {
		return equip_serv;
	}
	public void setEquip_serv(String equip_serv) {
		this.equip_serv = equip_serv;
	}
	public String getGeContractCode() {
		return geContractCode;
	}
	public void setGeContractCode(String geContractCode) {
		this.geContractCode = geContractCode;
	}
	public String getIps() {
		return ips;
	}
	public void setIps(String ips) {
		this.ips = ips;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getCountry_state() {
		return country_state;
	}
	public void setCountry_state(String country_state) {
		this.country_state = country_state;
	}
	public String getQuater() {
		return quater;
	}
	public void setQuater(String quater) {
		this.quater = quater;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getUnitcount() {
		return unitcount;
	}
	public void setUnitcount(String unitcount) {
		this.unitcount = unitcount;
	}
	public String getOrderSalesAmount() {
		return orderSalesAmount;
	}
	public void setOrderSalesAmount(String orderSalesAmount) {
		this.orderSalesAmount = orderSalesAmount;
	}
	public String getOrderSalesMargin() {
		return orderSalesMargin;
	}
	public void setOrderSalesMargin(String orderSalesMargin) {
		this.orderSalesMargin = orderSalesMargin;
	}
	public String getOrderSalesMarginper() {
		return orderSalesMarginper;
	}
	public void setOrderSalesMarginper(String orderSalesMarginper) {
		this.orderSalesMarginper = orderSalesMarginper;
	}
	public String getExt_oge_oi() {
		return ext_oge_oi;
	}
	public void setExt_oge_oi(String ext_oge_oi) {
		this.ext_oge_oi = ext_oge_oi;
	}
	public String getCountryRegion() {
		return countryRegion;
	}
	public void setCountryRegion(String countryRegion) {
		this.countryRegion = countryRegion;
	}
	public String getUsexport() {
		return usexport;
	}
	public void setUsexport(String usexport) {
		this.usexport = usexport;
	}
	public String getSubBusiness() {
		return subBusiness;
	}
	public void setSubBusiness(String subBusiness) {
		this.subBusiness = subBusiness;
	}
	public String getGgoSubRegion() {
		return ggoSubRegion;
	}
	public void setGgoSubRegion(String ggoSubRegion) {
		this.ggoSubRegion = ggoSubRegion;
	}
	public String getGgoCountry() {
		return ggoCountry;
	}
	public void setGgoCountry(String ggoCountry) {
		this.ggoCountry = ggoCountry;
	}
	public String getUsexp_dom() {
		return usexp_dom;
	}
	public void setUsexp_dom(String usexp_dom) {
		this.usexp_dom = usexp_dom;
	}
	public String getActuals() {
		return actuals;
	}
	public void setActuals(String actuals) {
		this.actuals = actuals;
	}
	@Override
	public String toString() {
		return "SearchResultsDataBean [geAlstom=" + geAlstom + ", business="
				+ business + ", segment=" + segment + ", order_sale_oi="
				+ order_sale_oi + ", equip_serv=" + equip_serv
				+ ", geContractCode=" + geContractCode + ", ips=" + ips
				+ ", customer=" + customer + ", project=" + project
				+ ", country_state=" + country_state + ", quater=" + quater
				+ ", model=" + model + ", unitcount=" + unitcount
				+ ", orderSalesAmount=" + orderSalesAmount
				+ ", orderSalesMargin=" + orderSalesMargin
				+ ", orderSalesMarginper=" + orderSalesMarginper
				+ ", ext_oge_oi=" + ext_oge_oi + ", countryRegion="
				+ countryRegion + ", usexport=" + usexport + ", subBusiness="
				+ subBusiness + ", ggoSubRegion=" + ggoSubRegion
				+ ", ggoCountry=" + ggoCountry + ", usexp_dom=" + usexp_dom
				+ ", actuals=" + actuals + "]";
	}
	
	
	private SearchResultsDataBean BuildTempList(String row){
		System.out.println("row :::"+row);
		
		String [] stringtok = row.split(",");		
			
			setGeAlstom(stringtok[0]);
			setBusiness(stringtok[1]);
			setSegment(stringtok[2]);
			setOrder_sale_oi(stringtok[3]);
			setEquip_serv(stringtok[4]);
			setGeContractCode(stringtok[5]);
			setIps(stringtok[6]);
			setCustomer(stringtok[7]);
			setProject(stringtok[8]);
			setCountry_state(stringtok[9]);			
			setQuater(stringtok[10]);			
			setModel(stringtok[11]);
			setUnitcount(stringtok[12]);
			setOrderSalesAmount(stringtok[13]);
			setOrderSalesMargin(stringtok[14]);
			setOrderSalesMarginper(stringtok[15]);
			setExt_oge_oi(stringtok[16]);
			setCountryRegion(stringtok[17]);
			setUsexport(stringtok[18]);
			setSubBusiness(stringtok[19]);
			setGgoSubRegion(stringtok[20]);
			setGgoCountry(stringtok[21]);
			setUsexp_dom(stringtok[22]);
			setActuals(stringtok[23]);
			return this;
		}
	
	public List<SearchResultsDataBean> BuildTempList(SearchCriteriaDataVO searchCriteria) throws IOException{
		String row="";
		List<SearchResultsDataBean> searchResults = new ArrayList<SearchResultsDataBean>();
		@SuppressWarnings("resource")
		BufferedReader bufferReader = new BufferedReader(new FileReader("D:\\Gegdc\\ES332958\\WORK\\financeappsearch\\src\\main\\resources\\DataFile.csv"));
		while((row=bufferReader.readLine())!=null){
		//	System.out.println("row:::"+row);
			SearchResultsDataBean searchResult = new SearchResultsDataBean().BuildTempList(row);
			/*if(searchCriteria.isNotNull()&&searchCriteria.isNotEmpty()){
				if(searchCriteria.equals(searchResult)){
					searchResults.add(searchResult);
				}
			}else{*/
				searchResults.add(searchResult);
			/*}*/
			
		}
		return searchResults;
	}
		
	
	
	
	
}