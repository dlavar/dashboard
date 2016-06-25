package com.ge.power.findashboard.vo;

import java.io.Serializable;
import java.util.List;

public class PacingMasterVO implements Serializable{

	List<String> business;
	public List<String> getBusiness() {
		return business;
	}
	public void setBusiness(List<String> business) {
		this.business = business;
	}
	public List<String> getEquipServ() {
		return equipServ;
	}
	public void setEquipServ(List<String> equipServ) {
		this.equipServ = equipServ;
	}
	public List<String> getStrcountryState() {
		return strcountryState;
	}
	public void setStrcountryState(List<String> strcountryState) {
		this.strcountryState = strcountryState;
	}
	public List<String> getStrQuater() {
		return strQuater;
	}
	public void setStrQuater(List<String> strQuater) {
		this.strQuater = strQuater;
	}
	public List<String> getStrYear() {
		return strYear;
	}
	public void setStrYear(List<String> strYear) {
		this.strYear = strYear;
	}
	List<String> equipServ;
	List<String> strcountryState;
	List<String> strQuater;
	List<String> strYear;

}
