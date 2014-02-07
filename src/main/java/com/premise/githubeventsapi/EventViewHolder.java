package com.premise.githubeventsapi;

import android.widget.TextView;

public class EventViewHolder {

	TextView eventId;
	
	TextView eventType;
	
	TextView eventCreatedAt;

	public TextView getEventId() {
		return eventId;
	}

	public void setEventId(TextView eventId) {
		this.eventId = eventId;
	}

	public TextView getEventType() {
		return eventType;
	}

	public void setEventType(TextView eventType) {
		this.eventType = eventType;
	}

	public TextView getEventCreatedAt() {
		return eventCreatedAt;
	}

	public void setEventCreatedAt(TextView eventCreatedAt) {
		this.eventCreatedAt = eventCreatedAt;
	}

}
