package com.jarvis.model;

public class CandidateDetail {
	private String applicationStatus;
	private String email;
	private String colorClass;
	
	public CandidateDetail(String applicationStatus,String email, String colorClass){
		this.setApplicationStatus(applicationStatus);
		this.setEmail(email);
		this.setColorClass(colorClass);
	}
	
	public CandidateDetail(){
		
	}
	public String getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getColorClass() {
		return colorClass;
	}

	public void setColorClass(String colorClass) {
		this.colorClass = colorClass;
	}
	
}
