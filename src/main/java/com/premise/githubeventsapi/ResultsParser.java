package com.premise.githubeventsapi;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

public class ResultsParser {

	private Context context;

	public ResultsParser(Context context) {
		this.context = context;
	}

	public List<Event> fromJsonArrayToStringList(JSONArray jsonArray) {
		List<Event> results = new ArrayList<Event>();
		
		if (jsonArray != null) {
			try {
				for (int i = 0; i < jsonArray.length(); i++) {
					JSONObject currentElement = jsonArray.getJSONObject(i);
					
					String id = currentElement.getString("id");
					String type = currentElement.getString("type");
					String createdAt = currentElement.getString("created_at");
					results.add(new Event(id, type, createdAt));
				}
			} catch (JSONException ex) {
				final String msg = "Unexpected error when parsing JSON response";
				Log.e("ResultsParser", msg, ex);
				Toast.makeText(this.context, msg, Toast.LENGTH_LONG).show();
			}
		}
		return results;
	}
}
