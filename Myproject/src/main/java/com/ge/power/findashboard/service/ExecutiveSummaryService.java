package com.ge.power.findashboard.service;

import java.util.Map;

import com.ge.power.findashboard.vo.FinancialGraphVO;

public interface ExecutiveSummaryService {
	public Map<String,FinancialGraphVO> getFinancialGraphDetails(String kpi,String qind,String quarter,String qendDate);
}
