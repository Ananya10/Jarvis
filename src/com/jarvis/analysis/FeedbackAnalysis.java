package com.jarvis.analysis;

import java.io.File;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class FeedbackAnalysis {
	
	public String OCR(String filePath) throws Exception
	{
		String apiKey = "0951d56f-0079-4023-b4e0-08d270d1e8a0";
		HttpClient httpclient = new DefaultHttpClient();
		String url = "https://api.havenondemand.com/1/api/sync/ocrdocument/v1";
		HttpPost httppost = new HttpPost(url);
		
		MultipartEntity reqEntity = new MultipartEntity();
		reqEntity.addPart("apikey",new StringBody(apiKey));
		File f = new File(filePath);
		
		reqEntity .addPart("file", new FileBody(f,ContentType.DEFAULT_BINARY));
		
		
		
		httppost.setEntity(reqEntity);

		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		return(responseString);
	}
	
	public String SentimentAnalysis(String text) throws Exception
	{
		String apiKey = "0951d56f-0079-4023-b4e0-08d270d1e8a0";
		HttpClient httpclient = new DefaultHttpClient();
		String url = "https://api.havenondemand.com/1/api/sync/analyzesentiment/v1";
		HttpPost httppost = new HttpPost(url);
		
		MultipartEntity reqEntity = new MultipartEntity();
		reqEntity.addPart("apikey",new StringBody(apiKey));
		
		reqEntity .addPart("text", new StringBody(text));
		
		
		
		httppost.setEntity(reqEntity);

		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		return(responseString);
	}

}
