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
		EventViewHolder viewHolder;

		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(
					Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.event, parent, false);

			viewHolder = new EventViewHolder();
			viewHolder.setEventId((TextView) convertView.findViewById(R.id.eventId));
			viewHolder.setEventType((TextView) convertView.findViewById(R.id.eventType));
			viewHolder.setEventCreatedAt((TextView) convertView.findViewById(R.id.eventCreatedAt));
			convertView.setTag(viewHolder);

		} else {
			viewHolder = (EventViewHolder) convertView.getTag();
		}

		Event event = this.getItem(position);
		viewHolder.getEventId().setText(event.getId());
		viewHolder.getEventType().setText(event.getType());
		viewHolder.getEventCreatedAt().setText(event.getCreatedAt());

		return convertView;
	}
}
