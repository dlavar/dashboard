package com.ge.power.findashboard.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import com.ge.power.findashboard.dao.FinDashUploadFileDao;

public class FinDashDaoUploadFileImpl implements FinDashUploadFileDao {
	
	@PersistenceUnit
	EntityManagerFactory emf;
	
	private EntityManager em;
	
	

	@Override
	public List<String> getSegmentData() throws Exception {
		List<String> results = null;				
		try{
			em = emf.createEntityManager();
			Query query = em.createNamedQuery("@GETSEGMENTS");
			if(query.getResultList().size()>0){
				results = query.getResultList();
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			em.close();
		}
		
		return null;
	}



	@Override
	public List<String> getCountryStateData() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
