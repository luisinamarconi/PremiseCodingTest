package com.premise.githubeventsapi;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		displayPublicEventList();
	}

	private void displayPublicEventList() {
		ListView eventList = (ListView) findViewById(R.id.eventsList);
		String[] publicEvents= getEventsFromGithub();
		ArrayAdapter<String> menuListAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, publicEvents );
		eventList.setAdapter(menuListAdapter);
	}

	private String[] getEventsFromGithub() {
		return new String[] { "Event 1", "Event2", "Event3" };
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
