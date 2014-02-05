package com.premise.githubeventsapi;

import java.util.List;

import org.json.JSONArray;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxStatus;

public class MainActivity extends Activity {

	private static final String URI = "https://api.github.com/events";

	private ResultsParser resultsParser = new ResultsParser(this);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		retrieveGitHubPublicEventList();
	}

	private void retrieveGitHubPublicEventList() {
		AQuery aq = new AQuery(getApplicationContext());
		aq.ajax(URI, JSONArray.class, this, "processResponse");
	}

	public void processResponse(String url, JSONArray json, AjaxStatus status) {
		if (json != null) {
			List<String> publicEvents = resultsParser.fromJsonArrayToStringList(json);
			this.displayContent(publicEvents);
		} else {
			Log.e("json response is null", status.getError());
			Toast.makeText(this, "unable to process events from Git Hub", Toast.LENGTH_LONG).show();
		}
	}

	public void displayContent(List<String> publicEvents) {
		ListView eventList = (ListView) findViewById(R.id.eventsList);

		ArrayAdapter<String> menuListAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
				publicEvents);
		eventList.setAdapter(menuListAdapter);
	}
}
