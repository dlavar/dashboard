package com.ge.power.findashboard.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ge.power.findashboard.entity.FinDashPacing;
import com.ge.power.findashboard.vo.SearchCriteriaDataVO;

/*import com.ge.power.findashboard.reposiitry.FinAppSearch;*/

@Component
@Repository
public class FinanceSearchDAO {
	private static final Logger logger = Logger.getLogger(FinanceSearchDAO.class);
	
	@PersistenceUnit
	private EntityManagerFactory emf;
	
	private EntityManager em;
	
	private List<FinDashPacing> resultList;
	public List<FinDashPacing> retrieveSearchResults(SearchCriteriaDataVO searchCriteria){
		logger.info("Inside SearchSynergyDataDAO and retrieveSearchResults method");
		logger.info("The Search Criteria passed is ........" + searchCriteria.toString());
		try{
						
			em = emf.createEntityManager();
			CriteriaBuilder cb = em.getCriteriaBuilder();						
			CriteriaQuery<FinDashPacing> creteriaQuery = cb.createQuery(FinDashPacing.class);
			Root<FinDashPacing> root = creteriaQuery.from(FinDashPacing.class);
			
			List<Predicate> predicates = new ArrayList<Predicate>();
			 if(searchCriteria.getStrBusiness()!=null && !searchCriteria.getStrBusiness().isEmpty()){
				 predicates.add(cb.equal(root.get("business"),searchCriteria.getStrBusiness()));			 
			 }
			 if(searchCriteria.getStrcountryState()!=null && !searchCriteria.getStrcountryState().isEmpty()){
				 predicates.add(cb.equal(root.get("countryUsState"),searchCriteria.getStrcountryState()));
			 }
			 if(searchCriteria.getStrEquipServ()!=null && !searchCriteria.getStrEquipServ().isEmpty()){
				 predicates.add(cb.equal(root.get("equipServ"),searchCriteria.getStrEquipServ()));
			 }
			 
			 if(searchCriteria.getStrQuater()!=null && !searchCriteria.getStrQuater().isEmpty()){
				 predicates.add(cb.equal(root.get("quarter"),searchCriteria.getStrQuater()));
			 }
			 
			 if(searchCriteria.getStrYear()!=null && !searchCriteria.getStrYear().isEmpty()){
				 predicates.add(cb.equal(root.get("year"),searchCriteria.getStrYear()));
			 }
			 
			 creteriaQuery.select(root).where(predicates.toArray(new Predicate[]{}));
			resultList = em.createQuery(creteriaQuery).getResultList();
			 
			logger.info("Size of ResultList::"+resultList.size());
		
			long endTime = System.currentTimeMillis();			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Exception Occured"+e.getStackTrace());
			logger.error("Error Message"+e.getMessage());
		}		
		finally{
			if(em.isOpen()){
				em.close();		 
			}
		}
		return resultList;
		
}
	
	
}