package com.jarvis.model;

public class CandidateDetail {
	private String applicationStatus;
	private String email;
	
	public CandidateDetail(String applicationStatus,String email){
		this.setApplicationStatus(applicationStatus);
		this.setEmail(email);
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
	
}
