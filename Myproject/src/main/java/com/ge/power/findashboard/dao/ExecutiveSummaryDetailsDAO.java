package com.ge.power.findashboard.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ge.power.findashboard.entity.FindashAlert;
import com.ge.power.findashboard.entity.FindashClosingOperationsAgg;
import com.ge.power.findashboard.entity.FindashClosingSchedule;
import com.ge.power.findashboard.entity.FindashMessage;
import com.ge.power.findashboard.entity.FindashProcessingRate;
import com.ge.power.findashboard.vo.FinacialQuaterVO;
import com.ge.power.findashboard.vo.FinancialGraphVO;

@Repository
public interface ExecutiveSummaryDetailsDAO {
	public List<FinacialQuaterVO> getQuaters() throws Exception;
	public List<FinancialGraphVO> getFinancialGraphDetails (String kpsList,String quaterIndicator,String quater,String quaterEndDate)throws Exception;
	public List<FindashClosingOperationsAgg> getOperationalGraphDetails() throws Exception;
	public List<FindashClosingOperationsAgg> getRunstatusDetails() throws Exception;
	public List<FindashClosingSchedule> getSchedulesDetails() throws Exception;
	public List<FindashProcessingRate> getProcessingRateDetails() throws Exception;
	public List<FindashAlert> getAlertDetails() throws Exception;
	public List<FindashMessage> getMessages() throws Exception;
}
