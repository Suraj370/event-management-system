package com.events.pojos;

public class Event implements Comparable<Event>
{
	private String eventId;
	private String eventName;
	private String eventDate;
	private Integer availableSeats;
	
	public Event(String eventId, String eventName, String eventDate, Integer availableSeats) {
		super();
		this.eventId = eventId;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.availableSeats = availableSeats;
	}
	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEventId() {
		return eventId;
	}
	public void setEventId(String eventId) {
		this.eventId = eventId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getEventDate() {
		return eventDate;
	}
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventName=" + eventName + ", eventDate=" + eventDate
				+ ", availableSeats=" + availableSeats + "]";
	}
	
	
	@Override
	public int compareTo(Event o) {
		return -this.availableSeats.compareTo(o.availableSeats);
		
	}

	
	

}
