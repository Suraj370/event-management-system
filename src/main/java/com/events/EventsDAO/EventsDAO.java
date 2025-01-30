package com.events.EventsDAO;

import java.util.TreeSet;

import com.events.pojos.Event;

public interface EventsDAO 
{
	boolean addEvent(Event event);
	TreeSet<Event> getAllEvents();
	TreeSet<Event> getAllEventsSortedByDate();
	boolean deleteEvent(String eventId);
	Event updateEvent(Event newEvent);
	Event getEventByName(String eventName);
	
	

}
