package com.events.EventsDAO;

import java.util.Comparator;

import com.events.pojos.Event;

public class DateComparator implements Comparator<Event> {

	@Override
	public int compare(Event o1, Event o2) {
	
		return o1.getEventDate().compareTo(o2.getEventDate());
	}

}
