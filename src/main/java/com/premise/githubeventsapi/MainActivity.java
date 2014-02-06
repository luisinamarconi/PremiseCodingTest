package com.premise.githubeventsapi;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

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

		EventsRetriever eventsRetriever = new EventsRetriever();
		eventsRetriever.execute(new String[] { URI });
	}

	public void processResponse(JSONArray json) {
		if (json != null) {
			List<Event> publicEvents = resultsParser.fromJsonArrayToStringList(json);
			this.displayContent(publicEvents);
		} else {
			Log.e("json response is null", null);
			Toast.makeText(this, "unable to process events from Git Hub", Toast.LENGTH_LONG).show();
		}
	}

	public void displayContent(List<Event> publicEvents) {
		ListView eventList = (ListView) findViewById(R.id.eventsList);

		EventListAdapter eventListAdapter = new EventListAdapter(this, R.layout.event, publicEvents);
		eventList.setAdapter(eventListAdapter);
	}

	class EventsRetriever extends AsyncTask<String, Integer, String> {

		@Override
		protected String doInBackground(String... params) {
			return new HttpRetriever().retrieve(params[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			try {
				processResponse(new JSONArray(result));
			} catch (JSONException e) {
				Log.e("EventsRetriever"," Error while processing JSON response ", e);
			}
		}

	}
}
