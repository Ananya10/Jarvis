package com.jarvis.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jarvis.model.LoginDetails;

@Controller
public class LoginController {

	@RequestMapping(value="/home.html" ,method = RequestMethod.POST)
	ModelAndView add(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		LoginDetails loginDetails = new LoginDetails();
		
		String emailID = request.getParameter("inputEmail3");
		String accountType = request.getParameter("inputAccountType");

		request.getSession().setAttribute("userName", emailID);
		
		loginDetails.setEmail(emailID);
		loginDetails.setAccountType(accountType);

		if(accountType.equals("Recruiter")){
			return new ModelAndView("RecruiterLanding/recruiter", "employee",loginDetails);
		} else {
			return new ModelAndView("applicant/applicant", "candidate",loginDetails);

		}
	}
}
