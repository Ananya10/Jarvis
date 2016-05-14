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

public class ResumeAnalysis {
	
	public String EntityExtraction(String filePath) throws Exception
	{
		String apiKey = "0951d56f-0079-4023-b4e0-08d270d1e8a0";
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httppost = new HttpPost("https://api.havenondemand.com/1/api/sync/extractentities/v2");
		
		MultipartEntity reqEntity = new MultipartEntity();
		reqEntity.addPart("apikey",new StringBody(apiKey));
		File f = new File(filePath);
		
		reqEntity .addPart("file", new FileBody(f,ContentType.DEFAULT_BINARY));



		String[] types = new String[]{"places_eng","companies_eng","universities"};

		for (String type: types)
		{
			reqEntity .addPart("entity_type", new StringBody(type));
		} 

		//httppost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		httppost.setEntity(reqEntity);

		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();
		String responseString = EntityUtils.toString(entity, "UTF-8");
		return(responseString);

	}

}
