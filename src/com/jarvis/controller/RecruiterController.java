package com.jarvis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jarvis.model.CandidateDetail;
import com.jarvis.model.JobListing;

@Controller
public class RecruiterController {

	@RequestMapping(value="/recruit.html", method = RequestMethod.POST)
	ModelAndView add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		return new ModelAndView("RecruiterApplicantMenu/recruiterapplicant");
	}

	@RequestMapping(value="/home1.html", method = RequestMethod.POST)
	ModelAndView get(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		String jobID = request.getParameter("inputJobId");
		System.out.println("Refreshed same page:"+jobID);
		JobListing jl = new JobListing();
		jl.setJobID(jobID);

		List<CandidateDetail> cd = new ArrayList<CandidateDetail>();
		if(jobID.equals("J1234")){
			cd.add(new CandidateDetail("In Progress", "candidate1@gmail.com"));
			cd.add(new CandidateDetail("Selected", "candidate2@gmail.com"));
			cd.add(new CandidateDetail("In Progress", "candidate3@gmail.com"));
			cd.add(new CandidateDetail("Selected", "candidate4@gmail.com"));
		}else if(jobID.equals("J5678")){
			cd.add(new CandidateDetail("In Progress", "candidate1@gmail.com"));
			cd.add(new CandidateDetail("In Progress", "candidate3@gmail.com"));
			cd.add(new CandidateDetail("Selected", "candidate4@gmail.com"));
		}
		jl.setCandidateDetails(cd);

		return new ModelAndView("RecruiterLanding/recruiter","jobListing",jl);
	}
}
