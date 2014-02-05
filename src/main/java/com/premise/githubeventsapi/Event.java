package com.premise.githubeventsapi;

public class Event {

	String id;
	String type;
	String createdAt;


	public Event(String id, String type, String createdAt) {
		super();
		this.id = id;
		this.type = type;
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

}
