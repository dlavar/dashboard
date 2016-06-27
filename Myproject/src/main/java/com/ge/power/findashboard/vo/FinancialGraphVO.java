package com.ge.power.findashboard.vo;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ge.power.findashboard.entity.FindashClosingFinancePlan;
import com.ge.power.findashboard.entity.FindashClosingFinancialsAgg;
import com.ge.power.findashboard.entity.FindashClosingFinancialsRaw;

import lombok.ToString;

@ToString
public class FinancialGraphVO {
	
	private final static Logger logger = Logger.getLogger(FinancialGraphVO.class);
	
	private BigDecimal actuals;	
	private String cId;
	private Date cDate;
	private String cMonth;
	private Long cYear;
	private BigDecimal goal;
	private String kpi;
	private String quarter;
	private BigDecimal target;
	private List<GoalData> goalData;
	
	public List<GoalData> getGoalData() {
		return goalData;
	}

	public void setGoalData(List<GoalData> goalData) {
		this.goalData = goalData;
	}
	
	
	private List<FinancialGraphVO> financiGraphVoList;

	public List<FinancialGraphVO> getFinanciGraphVoList() {
		return financiGraphVoList;
	}

	public void setFinanciGraphVoList(List<FinancialGraphVO> financiGraphVoList) {
		this.financiGraphVoList = financiGraphVoList;
	}

	public BigDecimal getActuals() {
		return actuals;
	}

	public void setActuals(BigDecimal actuals) {
		this.actuals = actuals;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public String getcMonth() {
		return cMonth;
	}

	public void setcMonth(String cMonth) {
		this.cMonth = cMonth;
	}

	public Long getcYear() {
		return cYear;
	}

	public void setcYear(Long cYear) {
		this.cYear = cYear;
	}


	public BigDecimal getGoal() {
		return goal;
	}

	public void setGoal(BigDecimal goal) {
		this.goal = goal;
	}

	public String getKpi() {
		return kpi;
	}

	public void setKpi(String kpi) {
		this.kpi = kpi;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public BigDecimal getTarget() {
		return target;
	}

	public void setTarget(BigDecimal target) {
		this.target = target;
	}


	
	public Map<String,FinancialGraphVO> buildGraphMap(List<FindashClosingFinancialsAgg> findashGraphActualls,List<FindashClosingFinancePlan> findashGraphGoal){
		logger.info("In buildGraphMap Method:::");
		Map<String,FinancialGraphVO> financialGraphMap = null;
		this.getFinanciGraphVoList();
		
		try{
			financialGraphMap = new HashMap<String,FinancialGraphVO>();
			FinancialGraphVO graphVo = null;
			for(FindashClosingFinancialsAgg finagg: findashGraphActualls){
				graphVo = new FinancialGraphVO(finagg,findashGraphGoal);
				financialGraphMap.put(graphVo.getKpi(), graphVo);
			}
			/*List<FinancialGraphVO> voList = new FinancialGraphVO(findashGraphActualls,findashGrpahGoal);*/
			
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return financialGraphMap;
	}

	public FinancialGraphVO(){}
	public FinancialGraphVO(FindashClosingFinancialsAgg rec,List<FindashClosingFinancePlan> findashGrpahGoal) throws IllegalAccessException, InvocationTargetException{
		this.kpi = rec.getKpi();
		this.cDate=rec.getCDate();
		this.cMonth	= rec.getCMonth();
		this.cYear = rec.getCYear();
		this.cId = rec.getcId();
		this.actuals=rec.getActuals();
		this.target=rec.getTarget();
		this.goal = rec.getGoal();
		this.quarter=rec.getQuarter();
		//this.cId=rec.getcId();
		GoalData goalData = new GoalData(findashGrpahGoal);
		this.goalData=goalData.getGoalDataList();
				
		
	}
	/*public FinancialGraphVO(List<FindashClosingFinancialsAgg> fincloseaggList) throws IllegalAccessException, InvocationTargetException{
		if(fincloseaggList!=null && fincloseaggList.size()>0){
			financiGraphVoList=new ArrayList<FinancialGraphVO>();
			for(FindashClosingFinancialsAgg rec : fincloseaggList){
				FinancialGraphVO financialGraphVO = new FinancialGraphVO(rec);
				financiGraphVoList.add(financialGraphVO);
				
			}
			this.setFinanciGraphVoList(financiGraphVoList);
		}
		 
	}
	
	public FinancialGraphVO(List<FindashClosingFinancialsAgg> findashGraphActualls,List<FindashClosingFinancePlan> findashGrpahGoal) throws IllegalAccessException, InvocationTargetException{
			FinancialGraphVO vo = new FinancialGraphVO(findashGraphActualls);
			GoalData goalData = new GoalData(findashGrpahGoal);
			vo.setGoalData(goalData.getGoalDataList());
	}
	*/
	
}
class GoalData{
	private BigDecimal opPlan;
	private BigDecimal ordersPlan;
	private String rQuarter;
	private Long rYear;
	private BigDecimal revenuePlan;
	private List<GoalData> goalDataList;
	
	
	
	public List<GoalData> getGoalDataList() {
		return goalDataList;
	}
	public void setGoalDataList(List<GoalData> goalDataList) {
		this.goalDataList = goalDataList;
	}
	public BigDecimal getOpPlan() {
		return opPlan;
	}
	public void setOpPlan(BigDecimal opPlan) {
		this.opPlan = opPlan;
	}
	public BigDecimal getOrdersPlan() {
		return ordersPlan;
	}
	public void setOrdersPlan(BigDecimal ordersPlan) {
		this.ordersPlan = ordersPlan;
	}
	public String getrQuarter() {
		return rQuarter;
	}
	public void setrQuarter(String rQuarter) {
		this.rQuarter = rQuarter;
	}
	public Long getrYear() {
		return rYear;
	}
	public void setrYear(Long rYear) {
		this.rYear = rYear;
	}
	public BigDecimal getRevenuePlan() {
		return revenuePlan;
	}
	public void setRevenuePlan(BigDecimal revenuePlan) {
		this.revenuePlan = revenuePlan;
	}
	public GoalData(List<FindashClosingFinancePlan> findashPlanData){
		List<GoalData> goalData = new ArrayList<GoalData>();
		for(FindashClosingFinancePlan findashGoal : findashPlanData){
			GoalData golDat = new GoalData(findashGoal);
			goalData.add(golDat);
		}
		this.goalDataList = goalData;
	}
	public GoalData(FindashClosingFinancePlan financeplan){
		this.opPlan=financeplan.getOpPlan();
		this.ordersPlan=financeplan.getOrdersPlan();
		this.revenuePlan=financeplan.getRevenuePlan();
		this.rQuarter=financeplan.getRQuarter();
		this.rYear = financeplan.getRYear();
	}	
	
	
	
	
}
