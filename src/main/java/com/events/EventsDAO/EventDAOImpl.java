package com.events.EventsDAO;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import com.events.pojos.Event;

public class EventDAOImpl implements EventsDAO 
{
	private HashMap<String,Event> events;
	static TreeSet<Event> sortedEvents=new TreeSet<Event>();
	static TreeSet<Event> sortedEventsByDate=new TreeSet<Event>(new DateComparator());
	

	public EventDAOImpl(int capacity)
	{
		this.events=new HashMap<String,Event>(capacity);
	 
	}

	@Override
	public boolean addEvent(Event event) {

		events.put(event.getEventName(), event);
		
		return true;
	}

	@Override
	public TreeSet<Event> getAllEvents() {

		if(events.isEmpty())
			return null;
		else {
		
		   
		for (Map.Entry<String, Event> entry : events.entrySet()) {
			
			 sortedEvents.add(entry.getValue()); 
			
		}
		
		      
		return sortedEvents;
		}
			
	}

	@Override
	public boolean deleteEvent(String eventName)
	{
		if(events.containsKey(eventName)) {
			events.remove(eventName);
			return true;
		}
		return false;
	}

	@Override
	public Event getEventByName(String eventName) {

		Event res= null;
		
			res=events.get(eventName);
		
		
		return res;

	}

	@Override
	public Event updateEvent(Event newEvent) {
		Event res= null;
		if(events.containsKey(newEvent.getEventName()))
		{
			events.put(newEvent.getEventName(), newEvent);
		}
		return res ;
	}

	@Override
	public TreeSet<Event> getAllEventsSortedByDate() {
		for (Map.Entry<String, Event> entry : events.entrySet()) {
			
			 sortedEventsByDate.add(entry.getValue()); 
			
		}
		return  sortedEventsByDate;
	}

}
