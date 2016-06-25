/**
 * @author Uday KUmar Kasturi (212468348)
 *
 */
package com.ge.power.findashboard.vo;

import java.util.Map;

import org.springframework.context.annotation.Bean;


public class SearchCriteriaDataVO {
	
	private String strBusiness;
	private String strEquipServ;
	private String strcountryState;
	private String strQuater;
	private String strYear;
	
	
	
	
	
	
	public SearchCriteriaDataVO(){}
	public SearchCriteriaDataVO(String business, String equipServ,
			String countryState, String quater, String year) {
		
		setStrBusiness(business);
		setStrEquipServ(equipServ);
		setStrcountryState(countryState);
		setStrQuater(quater);
		setStrYear(year);
		// TODO Auto-generated constructor stub
	}
	public String getStrBusiness() {
		return strBusiness;
	}
	public void setStrBusiness(String strBusiness) {
		this.strBusiness = NullCheck(strBusiness)?strBusiness:"";
	}
	public String getStrEquipServ() {
		return strEquipServ;
	}
	public void setStrEquipServ(String strEquipServ) {
		this.strEquipServ = NullCheck(strEquipServ)?strEquipServ:"";
	}
	public String getStrcountryState() {
		return strcountryState;
	}
	public void setStrcountryState(String strcountryState) {
		this.strcountryState = NullCheck(strcountryState)?strcountryState:"";
	}
	public String getStrQuater() {
		return strQuater;
	}
	public void setStrQuater(String strQuater) {
		this.strQuater = NullCheck(strQuater)?strQuater:"";
	}
	public String getStrYear() {
		return strYear;
	}
	public void setStrYear(String strYear) {
		this.strYear = NullCheck(strYear)?strYear:"";
	}
	
	
	
	
	
	
	
	private boolean NullCheck(String s){
		return (s!=null && !s.isEmpty()&& !"null".equals(s) && !"".equals(s));
	}
	
	
	@Override
	public String toString() {
		return "SearchCriteriaDataVO [strBusiness=" + strBusiness
				+ ", strEquipServ=" + strEquipServ + ", strcountryState="
				+ strcountryState + ", strQuater=" + strQuater + ", strYear="
				+ strYear + "]";
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((strBusiness == null) ? 0 : strBusiness.hashCode());
		result = prime * result
				+ ((strEquipServ == null) ? 0 : strEquipServ.hashCode());
		result = prime * result
				+ ((strQuater == null) ? 0 : strQuater.hashCode());
		result = prime * result + ((strYear == null) ? 0 : strYear.hashCode());
		result = prime * result
				+ ((strcountryState == null) ? 0 : strcountryState.hashCode());
		return result;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SearchCriteriaDataVO other = (SearchCriteriaDataVO) obj;
		if (strBusiness == null) {
			if (other.strBusiness != null)
				return false;
		} else if (!strBusiness.equals(other.strBusiness))
			return false;
		if (strEquipServ == null) {
			if (other.strEquipServ != null)
				return false;
		} else if (!strEquipServ.equals(other.strEquipServ))
			return false;
		if (strQuater == null) {
			if (other.strQuater != null)
				return false;
		} else if (!strQuater.equals(other.strQuater))
			return false;
		if (strYear == null) {
			if (other.strYear != null)
				return false;
		} else if (!strYear.equals(other.strYear))
			return false;
		if (strcountryState == null) {
			if (other.strcountryState != null)
				return false;
		} else if (!strcountryState.equals(other.strcountryState))
			return false;
		return true;
	}
	public boolean isNotNull(){
		return (strBusiness!=null||strEquipServ!=null||strcountryState!=null||strQuater!=null||strYear!=null);
	}
	
	public boolean isNotEmpty(){
		return (!strBusiness.isEmpty()||!strEquipServ.isEmpty()||!strcountryState.isEmpty()||!strQuater.isEmpty()||!strYear.isEmpty());
	}
	
	
	
	
	/*private String projectID;
	private String versionID;
	private Map<String,String> version_ID;
	private String strMapScenario;
	private Map<String,String> mapScenario;
	private String strTier1;
	private String strTier2;
	private String strTier3;
	private String strIRcategory;
	private String strTheme;
	
	
	
	
	public SearchCriteriaDataVO(String projectID,String strMapScenario,String strTier1,String strTier2,String strTier3,String strIRcategory,String strTheme){
		if(NullCheck(projectID)){
			setProjectID(projectID);			
		}
		if(NullCheck(strMapScenario)){
			setStrMapScenario(strMapScenario);
		}
		if(NullCheck(strTier1)){
			setStrTier1(strTier1);
		}
		if(NullCheck(strTier2)){
			setStrTier2(strTier2);
		}
		
		if(NullCheck(strTier3)){
			setStrTier3(strTier3);
		}
		
		if(NullCheck(strIRcategory)){
			setStrIRcategory(strIRcategory);
		}
		
		if(NullCheck(strTheme)){
			setStrTheme(strTheme);
		}
	}
	
	
	
	public String getProjectID() {
		return projectID;
	}
	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}
	public String getVersionID() {
		return versionID;
	}
	public void setVersionID(String versionID) {
		this.versionID = versionID;
	}
	public Map<String, String> getVersion_ID() {
		return version_ID;
	}
	public void setVersion_ID(Map<String, String> version_ID) {
		this.version_ID = version_ID;
	}
	
	public String getStrMapScenario() {
		return strMapScenario;
	}
	public void setStrMapScenario(String strMapScenario) {
		this.strMapScenario = strMapScenario;
	}
	public Map<String, String> getMapScenario() {
		return mapScenario;
	}
	public void setMapScenario(Map<String, String> mapScenario) {
		this.mapScenario = mapScenario;
	}
	public String getStrTier1() {
		return strTier1;
	}
	public void setStrTier1(String strTier1) {
		this.strTier1 = strTier1;
	}
	public String getStrTier2() {
		return strTier2;
	}
	public void setStrTier2(String strTier2) {
		this.strTier2 = strTier2;
	}
	public String getStrTier3() {
		return strTier3;
	}
	public void setStrTier3(String strTier3) {
		this.strTier3 = strTier3;
	}
	public String getStrIRcategory() {
		return strIRcategory;
	}
	public void setStrIRcategory(String strIRcategory) {
		this.strIRcategory = strIRcategory;
	}
	public String getStrTheme() {
		return strTheme;
	}
	public void setStrTheme(String strTheme) {
		this.strTheme = strTheme;
	}
	
	
	
	
	


	
	private boolean NullCheck(String s){
		return (s!=null && !s.isEmpty()&& !"null".equals(s) && !"".equals(s));
	}*/
}
