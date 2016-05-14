package com.jarvis.model;

import java.util.ArrayList;
import java.util.List;

public class JobListing {

	private String jobID;
	private List<CandidateDetail> candidateDetails = new ArrayList<CandidateDetail>();

	public String getJobID() {
		return jobID;
	}

	public void setJobID(String jobID) {
		this.jobID = jobID;
	}

	public List<CandidateDetail> getCandidateDetails() {
		return candidateDetails;
	}

	public void setCandidateDetails(List<CandidateDetail> candidateDetails) {
		this.candidateDetails = candidateDetails;
	}
}
