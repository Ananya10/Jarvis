package com.jarvis.controller;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jarvis.analysis.FeedbackAnalysis;
import com.jarvis.analysis.TestAnalysis;
import com.jarvis.model.CodingTest;
import com.jarvis.model.Result;

@Controller
public class FeedBackUploadController {

	@RequestMapping(value = "/feedback.html", method = RequestMethod.POST)
	public ModelAndView uploadFileHandler(@RequestParam("exampleInputFile2") MultipartFile file, HttpServletRequest request) throws Exception {

		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath()
						+ File.separator + "feedback.jpg");
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

			} catch (Exception e) {
			}
		}
		FeedbackAnalysis feedbackAnalysis = new FeedbackAnalysis();
		String response = feedbackAnalysis.OCR("E:\\JAVA\\hackathon2016\\apache-tomcat-7.0.69-windows-x64\\apache-tomcat-7.0.69\\tmpFiles\\feedback.jpg");
		
		JSONObject jsonObject = new JSONObject(response);
		JSONArray jsonArray = jsonObject.getJSONArray("text_block");
		String text = jsonArray.getJSONObject(0).getString("text");
		
		response = feedbackAnalysis.SentimentAnalysis(text);
		System.out.println(response);
		
		jsonObject = new JSONObject(response);
		JSONObject jo = jsonObject.getJSONObject("aggregate");
		
		Result result = new Result();
		result.setScore(jo.getDouble("score"));
		result.setSentiment(jo.getString("sentiment"));
		result.setText(text);
		
		request.getSession().setAttribute("tabID", "#panel-244498");
		
		return new ModelAndView("RecruiterApplicantMenu/recruiterapplicant","result",result);
	}
	
	@RequestMapping(value = "/prediction.html", method = RequestMethod.POST)
	public ModelAndView predict(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String query1 = "{ \"name\": \"name\",\"fields\": [{\"name\": \"Score\",\"type\": \"INTEGER\"},{\"name\": \"Rating\",\"type\": \"RICH_TEXT\"}],\"values\": [ {\"row\": [";
		String query3 = ",-1]}]}";
		
		String query = query1+ request.getParameter("applicantScore")+query3;
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(System.getProperty("catalina.home")+File.separator+"PredictData.json"));
		bw.write(query);
		bw.close();
		
		System.out.println(query);
		
		TestAnalysis analysis = new TestAnalysis();
		String result = analysis.Predict("E:\\JAVA\\hackathon2016\\apache-tomcat-7.0.69-windows-x64\\apache-tomcat-7.0.69\\PredictData.json","PredictionTest13");
		
		JSONObject jsonObject = new JSONObject(result);
		JSONArray jo = jsonObject.getJSONArray("values");
		JSONObject jo1 = jo.getJSONObject(0);
		
		JSONArray jo2 = jo1.getJSONArray("row");
		String text = "She/He is a "+jo2.get(2)+" fit";
		System.out.println(text);
		
		CodingTest codingTest = new CodingTest();
		codingTest.setScore(request.getParameter("applicantScore"));
		codingTest.setRating(text);
		
		request.getSession().setAttribute("tabID", "#panel-244497");
		
		return new ModelAndView("RecruiterApplicantMenu/recruiterapplicant","codingTest",codingTest);
	}
}
