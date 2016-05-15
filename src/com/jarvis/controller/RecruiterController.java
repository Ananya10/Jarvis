package com.jarvis.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jarvis.analysis.ResumeAnalysis;
import com.jarvis.model.CandidateDetail;
import com.jarvis.model.JobListing;

@Controller
public class RecruiterController {

	@RequestMapping(value="/recruit.html", method = RequestMethod.POST)
	ModelAndView add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String summary = getSummary();
		request.getSession().setAttribute("summary", summary);
		return new ModelAndView("RecruiterApplicantMenu/recruiterapplicant","summary",summary);
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
			cd.add(new CandidateDetail("In Progress", "candidate1@gmail.com", ""));
			cd.add(new CandidateDetail("Selected", "candidate2@gmail.com", "success"));
			cd.add(new CandidateDetail("In Progress", "candidate3@gmail.com", ""));
			cd.add(new CandidateDetail("Not Selected", "candidate4@gmail.com","danger"));
		}else if(jobID.equals("J5678")){
			cd.add(new CandidateDetail("In Progress", "candidate1@gmail.com",""));
			cd.add(new CandidateDetail("In Progress", "candidate3@gmail.com",""));
			cd.add(new CandidateDetail("Selected", "candidate4@gmail.com","success"));
		}
		jl.setCandidateDetails(cd);

		return new ModelAndView("RecruiterLanding/recruiter","jobListing",jl);
	}

	String getSummary() throws Exception{
		
		ResumeAnalysis resumeAnalysis = new ResumeAnalysis();
		String jsonData = resumeAnalysis.EntityExtraction("E:\\ANGELHACK\\JARVIS\\WebContent\\resume\\Resume.pdf");
		
		JSONObject jsonObject = new JSONObject(jsonData);
		JSONArray jsonArray = jsonObject.getJSONArray("entities");
		StringBuilder places = new StringBuilder();
		StringBuilder companies = new StringBuilder();
		StringBuilder universities = new StringBuilder();
		StringBuilder professions = new StringBuilder();

		for(int i = 0 ; i < jsonArray.length() ; i++){
			JSONObject jo = jsonArray.getJSONObject(i);

			//System.out.println(jo.get("normalized_text")+":"+jo.get("type")+":"+jo.getDouble("score"));
			if(jo.get("type").equals("places_eng")){
				places.append(jo.get("normalized_text")+":");
			}
			if(jo.get("type").equals("universities")){
				universities.append(jo.get("normalized_text")+":");
			}
			if(jo.get("type").equals("companies_eng")){
				companies.append(jo.get("normalized_text")+":");
			}
			if(jo.getDouble("score")>=0.3){
				if(jo.get("type").equals("professions")){
					professions.append(jo.get("normalized_text")+":");
				}
			}
		}

		StringBuilder finalString = new StringBuilder();

		finalString.append("Universities studied at/affiliated to:");
		String [] splitArr = universities.toString().split(":");

		finalString.append(splitArr[0]);
		for(int i =1 ; i< splitArr.length ; i++){
			finalString.append(";"+splitArr[i]);
		}

		finalString.append("\nCompanies worked at:");
		splitArr = companies.toString().split(":");

		finalString.append(splitArr[0]);
		for(int i =1 ; i< splitArr.length ; i++){
			finalString.append(";"+splitArr[i]);
		}


		finalString.append("\nPositions held:");
		splitArr = professions.toString().split(":");

		finalString.append(splitArr[0]);
		for(int i =1 ; i< splitArr.length ; i++){
			finalString.append(";"+splitArr[i]);
		}
		
		
		finalString.append("\nPlaces Stayed at:");
		splitArr = places.toString().split(":");

		finalString.append(splitArr[0]);
		for(int i =1 ; i< splitArr.length ; i++){
			finalString.append(";"+splitArr[i]);
		}
		System.out.println(finalString);
		return finalString.toString();
	}
}
