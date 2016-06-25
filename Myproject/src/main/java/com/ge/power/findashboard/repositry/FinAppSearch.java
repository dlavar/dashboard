package com.ge.power.findashboard.repositry;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.ge.power.findashboard.entity.FinDashPacing;
import com.ge.power.findashboard.vo.SearchCriteriaDataVO;

public class FinAppSearch{

	@SuppressWarnings("unchecked")
	@PersistenceContext(unitName="FinanceDashboard")
	public List<FinDashPacing> getSearchData(SearchCriteriaDataVO searchCriteria,EntityManager entityManager) {	
		
		List<FinDashPacing> searchResults=null;		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery query = cb.createQuery();
		 Root<FinDashPacing> findashpacintStg = query.from(FinDashPacing.class);
		 List<Predicate> predicates = new ArrayList<Predicate>();
		 if(searchCriteria.getStrBusiness()!=null && !searchCriteria.getStrBusiness().isEmpty()){
			 predicates.add(cb.equal(findashpacintStg.get("business"),searchCriteria.getStrBusiness()));			 
		 }
		 if(searchCriteria.getStrcountryState()!=null && !searchCriteria.getStrcountryState().isEmpty()){
			 predicates.add(cb.equal(findashpacintStg.get("countryUsState"),searchCriteria.getStrcountryState()));
		 }
		 if(searchCriteria.getStrEquipServ()!=null && !searchCriteria.getStrEquipServ().isEmpty()){
			 predicates.add(cb.equal(findashpacintStg.get("equipServ"),searchCriteria.getStrEquipServ()));
		 }
		 
		 if(searchCriteria.getStrQuater()!=null && !searchCriteria.getStrQuater().isEmpty()){
			 predicates.add(cb.equal(findashpacintStg.get("quarter"),searchCriteria.getStrQuater()));
		 }
		 
		 if(searchCriteria.getStrYear()!=null && !searchCriteria.getStrYear().isEmpty()){
			 predicates.add(cb.equal(findashpacintStg.get("year"),searchCriteria.getStrYear()));
		 }
		 
		 	query.select(findashpacintStg).where(predicates.toArray(new Predicate[]{}));
		 
		 	searchResults = entityManager.createQuery(query).getResultList();
		 
		return searchResults;

	}

}
