package com.ge.power.findashboard.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceException;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.ge.power.findashboard.entity.FinDashBatchTracker;
import com.ge.power.findashboard.entity.FinDashPacingErrChk;

@Repository
@Transactional
public class ExcelToTableUpload implements FileUploadDao{
	@PersistenceUnit
	private EntityManagerFactory emf;
	private EntityManager em;

	@Override
	public Boolean uploadFileToTable(List<Object> uploadVo) throws Exception
	{
		Boolean flag = true;
		try{
			em = emf.createEntityManager();
			em.getTransaction().begin();
			for(Object obj:uploadVo){
				em.persist(obj);					
			}
			em.getTransaction().commit();				
		}catch(PersistenceException per){
			flag=false;
			per.printStackTrace();
			em.getTransaction().rollback();
			
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
			em.getTransaction().rollback();			
		
		}finally{
			em.close();
		}	
		return flag;
		
	}
	@Override
	public int getBatchId(FinDashBatchTracker findashBatchTracker) throws Exception {
		int batchId = 0;
		EntityManager em = null;
		try{
			em=emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(findashBatchTracker);					
			em.getTransaction().commit();
			//batchId=findashBatchTracker.getBatchId();	
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}finally{
			em.close();
		}
		return batchId;
	}
	
	@Override
	public int getBatchIdfromSeq(){
		int batchId=0;
		EntityManager em = null;
		try{
			em= emf.createEntityManager();
			Query q = em.createNativeQuery("SELECT FINDASH_TRACKER.NEXTVAL FROM DUAL");
			Object obj = q.getSingleResult();
			batchId = Integer.valueOf(obj.toString());	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		return batchId;
	}
	@Override
	public List<String> getCountryStateData() throws Exception{
		EntityManager em = null;
		List obj=null;
		try{
			em= emf.createEntityManager();
			Query q = em.createNamedQuery("@CountryState");
			obj = q.getResultList();
	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		return obj;
	}
	@Override
	public List<String> getCountryRegionList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Integer callErrorCheckProcedure(Integer batchId)
			throws Exception {
		EntityManager em = null;
		List obj=null;
		Integer flag = 0;
		try{
			em= emf.createEntityManager();
			StoredProcedureQuery stquery = em.createStoredProcedureQuery("Pacing_Err_Chk");
			
			stquery.registerStoredProcedureParameter("BatchId",Integer.class,ParameterMode.IN);
			stquery.registerStoredProcedureParameter("Flag",Integer.class,ParameterMode.OUT);
			stquery.setParameter("BatchId",batchId);
			stquery.execute();
			flag = (Integer)stquery.getOutputParameterValue("Flag");
	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		return flag;
	}
		
	public List<FinDashPacingErrChk> getErrorDetails(Integer batchId)
			throws Exception {
		EntityManager em = null;
		List<FinDashPacingErrChk> errorcheckDetails=null;
		Integer flag = 0;
		try{
			em= emf.createEntityManager();
			Query stquery = em.createNamedQuery("@GETERRORCHECKDETAILS");
			stquery.setParameter("batchId", batchId);
			errorcheckDetails=stquery.getResultList();
			
	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		return errorcheckDetails;
	}
	
	

}
