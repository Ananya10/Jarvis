package com.jarvis.analysis;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MimeType;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.ByteArrayBody;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.http.*;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception
	{

		//ResumeAnalysis resumeAnalysis = new ResumeAnalysis();
		//String response = resumeAnalysis.EntityExtraction("C:\\Hackathon\\SampleResume\\Resume.pdf");
		
		TestAnalysis testAnalysis = new TestAnalysis();
		//String response = testAnalysis.Train("C:\\Hackathon\\SampleTrainingData\\Training4.json");
		
		String response = testAnalysis.Predict("C:\\Hackathon\\SampleTrainingData\\Predict.json","PredictionTest13");
		
		System.out.println(response);

	}


}
