package com.ge.power.findashboard.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ge.power.findashboard.constants.FinAppConstants;
import com.ge.power.findashboard.dao.ExecutiveSummaryDetailsDAO;
import com.ge.power.findashboard.dao.impl.commons.FindashBoardDateUtil;
import com.ge.power.findashboard.entity.FindashClosingFinancePlan;
import com.ge.power.findashboard.entity.FindashClosingFinancialsAgg;
import com.ge.power.findashboard.service.ExecutiveSummaryService;
import com.ge.power.findashboard.vo.FinancialGraphVO;


@Service
public class ExecutiveSummaryServiceImpl implements ExecutiveSummaryService {
	
	private static final Logger logger = Logger.getLogger(ExecutiveSummaryServiceImpl.class);
	
	@Autowired
	ExecutiveSummaryDetailsDAO executiveSummaryDao;
	
	
	@Override
	public Map<String, FinancialGraphVO> getFinancialGraphDetails(String kpiList, String quaterIndicator, String quater, String quaterEndDate) {
		logger.info("in GetFinanciGraphDetails Method");
		Map<String,FinancialGraphVO> graphDetailsMap=null;
		List<FindashClosingFinancialsAgg> findashGraphActualls = null;
		List<FindashClosingFinancePlan> findashGrpahGoal = null;
		Long year = null ;
		FinancialGraphVO finGraphVo = null;
 		try{
 			 
 			 finGraphVo= new FinancialGraphVO();
 			 year = Long.valueOf(FindashBoardDateUtil.formatDate(quaterEndDate,FinAppConstants.YEAR));
			 findashGraphActualls=executiveSummaryDao.getFinancialGraphDetails(kpiList, quaterIndicator, quater, year);
			 findashGrpahGoal = executiveSummaryDao.getFinacialGraphGoalDetails(quater, year);
			 graphDetailsMap=finGraphVo.buildGraphMap(findashGraphActualls,findashGrpahGoal);
			 
			 
			 
		}catch (Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
			
		}
		logger.info("Before Returning the Value:::");
		return graphDetailsMap;
		
		
	}

}
