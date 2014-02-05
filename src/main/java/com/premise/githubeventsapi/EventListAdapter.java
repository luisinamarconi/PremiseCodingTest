package com.premise.githubeventsapi;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EventListAdapter extends ArrayAdapter<Event> {

	public EventListAdapter(Context context, int textViewResourceId, List<Event> events) {
		super(context, textViewResourceId, events);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;

		if (row == null) {
			LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			row = inflater.inflate(R.layout.event, parent, false);
		}

		TextView eventId = (TextView) row.findViewById(R.id.eventId);
		TextView eventType = (TextView) row.findViewById(R.id.eventType);
		TextView eventCreatedAt = (TextView) row.findViewById(R.id.eventCreatedAt);
		Event event = this.getItem(position);
		eventId.setText(event.getId());
		eventType.setText(event.getType());
		eventCreatedAt.setText(event.getCreatedAt());

		return row;
	}
}
