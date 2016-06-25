package com.ge.power.findashboard.vo;

import java.util.ArrayList;
import java.util.List;

public class FinancialKpiVO {
	private String kpiName;
	private String kpiCode;
	
	
	public String getKpiName() {
		return kpiName;
	}
	public void setKpiName(String kpiName) {
		this.kpiName = kpiName;
	}
	public String getKpiCode() {
		return kpiCode;
	}
	public void setKpiCode(String kpiCode) {
		this.kpiCode = kpiCode;
	}
	
	
	public static List<FinancialKpiVO> buildKpiList(){
		List<FinancialKpiVO> kpiList = new ArrayList<FinancialKpiVO>();
		String[] Kpis = {"Orders","Units","Revenue","Contribution Margin %","Base Costs","RTS","Programs","SG&A","Gross Margin","Gross Margin %","Operating Profit","Op Profit %","Net Income","CFOA","CapEx","FCF"};
		for(String kp:Kpis){
			FinancialKpiVO kpivo = new FinancialKpiVO();
			kpivo.setKpiCode(kp);
			kpivo.setKpiName(kp);
			kpiList.add(kpivo);
		}
		return kpiList;
		
		
	}

}
