package com.events.eventsService;

import java.util.HashMap;
import java.util.TreeSet;

import com.events.pojos.Event;

public interface EventsService {

	boolean addEvent(Event event);
	TreeSet<Event> getAllEvents();
	Event getEventByName(String eventName);
	TreeSet<Event> getAllEventsSortedByDate();
	boolean deleteEvent(String eventId);
	Event updateEvent(Event newEvent);
	String registerForEvent(String eventId);
}
