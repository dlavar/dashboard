package com.ge.power.findashboard.vo;



public class UploadVO<T> {
	Boolean uploadStatus;
	T uservo;
	public Boolean getUploadStatus() {
		return uploadStatus;
	}
	public void setUploadStatus(Boolean uploadStatus) {
		this.uploadStatus = uploadStatus;
	}
	public T getUservo() {
		return uservo;
	}
	public void setUservo(T uservo) {
		this.uservo = uservo;
	}
	
	
}
