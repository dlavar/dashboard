package com.ge.power.findashboard.controller;


import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ge.power.findashboard.dao.ExecutiveSummaryDetailsDAO;
import com.ge.power.findashboard.entity.FindashAlert;
import com.ge.power.findashboard.entity.FindashClosingOperationsAgg;
import com.ge.power.findashboard.entity.FindashClosingSchedule;
import com.ge.power.findashboard.entity.FindashMessage;
import com.ge.power.findashboard.entity.FindashProcessingRate;
import com.ge.power.findashboard.service.DashboardService;
import com.ge.power.findashboard.vo.FinacialQuaterVO;
import com.ge.power.findashboard.vo.FinancialGraphVO;
import com.ge.power.findashboard.vo.FinancialKpiVO;
import com.ge.power.findashboard.vo.UserVO;



@RestController
@RequestMapping("/services")
public class DashboardController {
	@Autowired 
	private DashboardService dashboardService;
	
	@Autowired
	private ExecutiveSummaryDetailsDAO executiveSummaryDao;
	
	
	@RequestMapping(value="/get/userDetails", method = RequestMethod.GET, produces =  "application/json")
	public @ResponseBody String userDetails() throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		System.out.println(" in Type MasterService Manager userDetails Method...");
		List<UserVO> userDetails= dashboardService.userDetails();
		System.out.println("returning the response-----> userDetails MasterData");
		return "Satyan";
	}	
	
	@RequestMapping(value="/executiveSummary/getKpis")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FinancialKpiVO> getKpis(){
		List<FinancialKpiVO> kpiList=null;
		kpiList = FinancialKpiVO.buildKpiList();		
		return kpiList;
			
	}
	
	@RequestMapping(value="/executiveSummary/getQuaters")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FinacialQuaterVO> getQuaters() throws Exception{
		List<FinacialQuaterVO> quatersList=null;
		quatersList = executiveSummaryDao.getQuaters();	
		return quatersList;		
	}
	
	@RequestMapping(value="/executiveSummary/getFinancialChartValues")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FinancialGraphVO> getFinancialGraphDetails(@RequestParam("kpi") String kpsList,@RequestParam("qind") String quaterIndicator,@RequestParam("quarter") String quater,@RequestParam("qEndDate") String qEndDate) throws Exception{		
		List<FinancialGraphVO> graphDetails = null;
		graphDetails = executiveSummaryDao.getFinancialGraphDetails(kpsList,quaterIndicator,quater,qEndDate);
		return graphDetails;
		
	}
	
	
	@RequestMapping(value="/executiveSummary/getFinancialOperationDetails")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FindashClosingOperationsAgg> getOperationalGraphDetails() throws Exception{		
		List<FindashClosingOperationsAgg> opGraphDetails = null;
		opGraphDetails = executiveSummaryDao.getOperationalGraphDetails();
		return opGraphDetails;
		
	}
	
	@RequestMapping(value="/executiveSummary/getRunStatusDetails")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FindashClosingOperationsAgg> getRunstatusDetails() throws Exception{		
		List<FindashClosingOperationsAgg> opGraphDetails = null;
		opGraphDetails = executiveSummaryDao.getRunstatusDetails();
		return opGraphDetails;
		
	}
	
	@RequestMapping(value="/executiveSummary/getSchedulesDetails")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FindashClosingSchedule> getScheduleDetails() throws Exception{		
		List<FindashClosingSchedule> opGraphDetails = null;
		opGraphDetails = executiveSummaryDao.getSchedulesDetails();
		return opGraphDetails;
		
	}
	
	@RequestMapping(value="/executiveSummary/getProcessingRate")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FindashProcessingRate> getprocessingRate() throws Exception{		
		List<FindashProcessingRate> processingDetails = null;
		processingDetails = executiveSummaryDao.getProcessingRateDetails();
		return processingDetails;
		
	}
	
	@RequestMapping(value="/executiveSummary/getAlertDetails")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FindashAlert> getAlertDetails() throws Exception{		
		List<FindashAlert> alertDetails = null;
		alertDetails = executiveSummaryDao.getAlertDetails();
		return alertDetails;
		
	}
	
	
	@RequestMapping(value="/executiveSummary/getMessages")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<FindashMessage> getMessages() throws Exception{		
		List<FindashMessage> messages = null;
		messages = executiveSummaryDao.getMessages();
		return messages;
		
	}
	
	
	
	
}
	