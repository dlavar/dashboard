package com.ge.power.findashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.ge.power.findashboard.constants.FinAppConstants;
import com.ge.power.findashboard.dao.ExecutiveSummaryDetailsDAO;
import com.ge.power.findashboard.dao.impl.commons.FindashBoardDateUtil;
import com.ge.power.findashboard.entity.FindashAlert;
import com.ge.power.findashboard.entity.FindashClosingFinancePlan;
import com.ge.power.findashboard.entity.FindashClosingFinancialsAgg;
import com.ge.power.findashboard.entity.FindashClosingOperationsAgg;
import com.ge.power.findashboard.entity.FindashClosingSchedule;
import com.ge.power.findashboard.entity.FindashMessage;
import com.ge.power.findashboard.entity.FindashProcessingRate;
import com.ge.power.findashboard.vo.FinacialQuaterVO;
import com.ge.power.findashboard.vo.FinancialGraphVO;

@Repository
public class ExecutiveSummaryDetailsDaoImpl implements ExecutiveSummaryDetailsDAO {
	
	
	private static final Logger logger = Logger.getLogger(ExecutiveSummaryDetailsDaoImpl.class);

	@PersistenceUnit
	EntityManagerFactory emf;
	
	@Override
	public List<FinacialQuaterVO> getQuaters() {
		EntityManager em = null;
		List<FinacialQuaterVO> quatersList=null;
		try{
			em = emf.createEntityManager();
			Query query = em.createNamedQuery("@GETTQUATERENDDATES");
			
			List<Object[]> result = query.setMaxResults(FinAppConstants.MAX_QUARTERSLIST).getResultList();
			quatersList = new ArrayList<FinacialQuaterVO>();
			int i=1;
			for(Object[] rec: result){
				FinacialQuaterVO vo = new FinacialQuaterVO();
				if(i==1){
				vo.setQuaterCode(FinAppConstants.CURRENT_QUARTER_INDICATOR);
				i++;
				}else{
					vo.setQuaterCode(FinAppConstants.PREVIOUS_QUARTER_INDICATOR);
				}
				vo.setQuater((String.valueOf(rec[0])));
				vo.setQuaterEndDate(String.valueOf(rec[1]));				
				vo.setQuaterEndDateFormatted(FindashBoardDateUtil.formatDate(String.valueOf(rec[1]),FinAppConstants.QUATERENDDATEFORAMT));
				quatersList.add(vo);
				
			}
			
		}catch(Exception e ){
			e.printStackTrace();
		}finally{
			em.close();
		}
		return quatersList;
	}

	@Override
	public List<FindashClosingFinancialsAgg> getFinancialGraphDetails(String kpsList,String quaterIndicator,String quater,	Long year) {
		
		List<FinancialGraphVO> graphDetails= null;
		List<String> kpListstring= new ArrayList<String>();
		EntityManager em = null;
		List<FindashClosingFinancialsAgg> results=null;
		try{
			StringBuffer stf= new StringBuffer();
			StringTokenizer stk = new StringTokenizer(kpsList,",");
			while(stk.hasMoreTokens()){
				kpListstring.add(stk.nextToken());				
			}
			for(String s: kpListstring){
				logger.info("List of KPIs :::"+s);
			}
			em = emf.createEntityManager();
			Query q = em.createNamedQuery("@GETKPISDETAISL").setParameter("s",kpListstring);
			logger.info("Named Query::: @GETKPISDETAISL");
			q.setParameter("year",year);
			q.setParameter("quarter",quater);
			logger.info("Paramers::: Kps:"+kpListstring+"year:::"+year+"quarter"+quater);
			results = q.getResultList();
			/*FinancialGraphVO vo = new FinancialGraphVO(results);
			graphDetails = vo.getFinanciGraphVoList();		*/	
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		
		//return graphDetails;
		return results;
	}

	@Override
	public List<FindashClosingOperationsAgg> getOperationalGraphDetails()
			throws Exception {
		EntityManager em =null;
		List<FindashClosingOperationsAgg> agg=null;
		try{
			em = emf.createEntityManager();
			Query q = em.createNamedQuery("@GETOPERATIONALDETAILS");
			agg=q.getResultList();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		return agg;		

	}

	@Override
	public List<FindashClosingOperationsAgg> getRunstatusDetails()
			throws Exception {
		List<FindashClosingOperationsAgg>  results = null;
		EntityManager em = null;
				try{
					em = emf.createEntityManager();
					Query q = em.createNamedQuery("@FINDASHCLOSINGRUNSTATUSDETAILS");
					results=q.setMaxResults(10).getResultList();
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					em.close();
				}
				return results;
	}

	@Override
	public List<FindashClosingSchedule> getSchedulesDetails() throws Exception {
		// TODO Auto-generated method stub
		List<FindashClosingSchedule>  results = null;
		EntityManager em = null;
				try{
					em = emf.createEntityManager();
					Query q = em.createNamedQuery("@GETSECHEDULESINFO");
					results=q.setMaxResults(5).getResultList();
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					em.close();
				}
				return results;
	}

	@Override
	public List<FindashProcessingRate> getProcessingRateDetails()
			throws Exception {
		// TODO Auto-generated method stub
		List<FindashProcessingRate>  results = null;
		EntityManager em = null;
				try{
					em = emf.createEntityManager();
					Query q = em.createNamedQuery("@GETPROCESSINGDETAILS");
					results=q.setMaxResults(1).getResultList();
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					em.close();
				}
				return results;
	}
	@Override
	public List<FindashAlert> getAlertDetails()
			throws Exception {
		// TODO Auto-generated method stub
		List<FindashAlert>  results = null;
		EntityManager em = null;
				try{
					em = emf.createEntityManager();
					Query q = em.createNamedQuery("@GETALERTS");
					results=q.setMaxResults(20).getResultList();
					
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					em.close();
				}
				return results;
	}

	@Override
	public List<FindashMessage> getMessages() throws Exception {
		
			// TODO Auto-generated method stub
			List<FindashMessage>  results = null;
			EntityManager em = null;
					try{
						em = emf.createEntityManager();
						Query q = em.createNamedQuery("@GETALERTS");
						results=q.setMaxResults(20).getResultList();
						
					}catch(Exception e){
						e.printStackTrace();
					}finally{
						em.close();
					}
					return results;
	}

	/**
	 * @param quater
	 * @param quaterEndDate
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<FindashClosingFinancePlan> getFinacialGraphGoalDetails(String quater, Long year)
		throws Exception {
		logger.info("In getFinanciaGrpahGoalDetails--->Start");
		List<FindashClosingFinancePlan> goalDetails = null;
		EntityManager em = null;
		try{
			
			em = emf.createEntityManager();
			Query query= em.createNamedQuery("@GETGOALDETAILSDAILY");
			logger.info("Named Query Created:::@GETGOALDETAILSDAILY");
			query.setParameter("grainind",FinAppConstants.DAY_INDICATOR);
			query.setParameter("quarter", quater);
			query.setParameter("year", year);
			logger.info("PARAMETERS FOR QUERY:::GRAININD:"+FinAppConstants.DAY_INDICATOR+"quarter:"+quater+"year::"+year);
			goalDetails = query.getResultList();		
			logger.info("Query Execution Completed:::");
		}catch(Exception e){
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		logger.info("In getFinanciaGrpahGoalDetails--->End");
		return goalDetails;
	}
	
}
