package com.ge.power.findashboard.vo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.ToString;

import com.ge.power.findashboard.entity.FindashClosingFinancialsAgg;

@ToString
public class FinancialGraphVO {
	private String quater;
	private String quateEndDate;
	private String month;
	private String year;
	private String kpi;
	private BigDecimal actuals;
	private BigDecimal goal;
	private BigDecimal target;
	private String cid;
	
	
	
	private List<FinancialGraphVO> financiGraphVoList;
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public List<FinancialGraphVO> getFinanciGraphVoList() {
		return financiGraphVoList;
	}
	public void setFinanciGraphVoList(List<FinancialGraphVO> financiGraphVoList) {
		this.financiGraphVoList = financiGraphVoList;
	}
	public String getQuater() {
		return quater;
	}
	public void setQuater(String quater) {
		this.quater = quater;
	}
	public String getQuateEndDate() {
		return quateEndDate;
	}
	public void setQuateEndDate(String quateEndDate) {
		this.quateEndDate = quateEndDate;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getKpi() {
		return kpi;
	}
	public void setKpi(String kpi) {
		this.kpi = kpi;
	}
	public BigDecimal getActuals() {
		return actuals;
	}
	public void setActuals(BigDecimal actuals) {
		this.actuals = actuals;
	}
	public BigDecimal getGoal() {
		return goal;
	}
	public void setGoal(BigDecimal goal) {
		this.goal = goal;
	}
	public BigDecimal getTarget() {
		return target;
	}
	public void setTarget(BigDecimal target) {
		this.target = target;
	}
	
	
	public FinancialGraphVO(){}
	public FinancialGraphVO(Object[] rec){
		
			
		this.kpi=rec[0].toString();
		this.actuals=(BigDecimal) rec[1];
		this.goal=(BigDecimal) rec[2];
		this.month=rec[3].toString();
		this.quateEndDate=String.valueOf(rec[4]);
		this.target=(BigDecimal) rec[5];
		this.year=String.valueOf(rec[6]);
		this.quater=rec[7].toString();
		this.cid=rec[8].toString();
		
	}
	public FinancialGraphVO(List<Object> fincloseaggList){
		if(fincloseaggList!=null && fincloseaggList.size()>0){
			financiGraphVoList=new ArrayList<FinancialGraphVO>();
			for(Object rec : fincloseaggList){
				FinancialGraphVO financialGraphVO = new FinancialGraphVO((Object[])rec);
				financiGraphVoList.add(financialGraphVO);
				
			}
			this.setFinanciGraphVoList(financiGraphVoList);
		}
		 
	}
	
	
	
}
