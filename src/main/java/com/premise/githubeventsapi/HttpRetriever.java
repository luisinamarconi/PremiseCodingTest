package com.premise.githubeventsapi;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.util.Log;

/**
 * Generic class to perform HTTP invocations.
 */
public class HttpRetriever {

	private DefaultHttpClient client = new DefaultHttpClient();

	public String retrieve(String url) {
		HttpGet httpRequest = new HttpGet(url);
		try {
			httpRequest.setHeader("Accept", "application/json");
			HttpResponse response = this.client.execute(httpRequest);
			final int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode != HttpStatus.SC_OK) {
				Log.e(this.getClass().getSimpleName(), "Error " + statusCode + " for URL " + url);
				return null;
			}
			HttpEntity getResponseEntity = response.getEntity();
			if (getResponseEntity != null) {
				return EntityUtils.toString(getResponseEntity);
			}
		} catch (IOException e) {
			httpRequest.abort();
			Log.w(this.getClass().getSimpleName(), "Error found when invoking URL " + url, e);
		}
		return null;
	}

}
