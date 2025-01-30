package com.events.eventsController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeSet;

import com.events.eventsService.EventsService;
import com.events.pojos.Event;

public class EventsController 
{
	private EventsService eventsService;

	public EventsController(EventsService eventsService)
	{
		this.eventsService=eventsService;
	}

	public void start()
	{
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			System.out.println("\n--- Event Management System ---");
			System.out.println("1. Admin Login");
			System.out.println("2. User  Login");
			System.out.println("3. EXIT ");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();

			switch(choice)
			{
			case 1: 
				adminMenu(scanner);
				break;
			case 2:
				userMenu(scanner);
				break;
			case 3:
				System.out.println("Exiting Sytem . GoodBye!");
				scanner.close();
				return;
			default: System.out.println("invalid choice, please try again !");

			}

		}
	}

	private void adminMenu(Scanner scanner)
	{
		while(true)
		{
			System.out.println("\n--- Welcome Admin ---");
			System.out.println("1. Add Event");
			System.out.println("2. View Events");
			System.out.println("3. Delete Event ");
			System.out.println("4. Update event");
			System.out.println("5. Logout");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			scanner.nextLine();
			switch (choice) {
			case 1:
				System.out.print("Enter Event ID: ");
				String id = scanner.nextLine();
				System.out.print("Enter Event Name: ");
				String name = scanner.nextLine();
				System.out.print("Enter Event Date (DD/MM/YYYY): ");
				String date = scanner.nextLine();
				System.out.print("Enter Available Seats: ");
				int seats = scanner.nextInt();
				scanner.nextLine();

				if (eventsService.addEvent(new Event(id, name, date, seats))) {
					System.out.println("Event added successfully!");
				} else {
					System.out.println("Failed to add event. Storage is full.");
				}
				break;
			case 2:
				TreeSet<Event> events = eventsService.getAllEvents();
				if (events ==null ) {
					System.out.println("No events found.");
				} else {

					for (Event event : events) {
						System.out.println(event);
					}
				}
				break;
			case 3:
				System.out.print("Enter Event name to delete: ");
				String eventName = scanner.nextLine();
				if (eventsService.deleteEvent(eventName)) {
					System.out.println("Event deleted successfully!");
				} else {
					System.out.println("Event not found.");
				}
				break;
			case 4: System.out.print("Enter Event ID: ");
			String newid = scanner.nextLine();
			System.out.print("Enter Event Name: ");
			String newname = scanner.nextLine();
			System.out.print("Enter Event Date (DD/MM/YYYY): ");
			String newdate = scanner.nextLine();
			System.out.print("Enter Available Seats: ");
			int newseats = scanner.nextInt();

			if (eventsService.updateEvent(new Event(newid, newname, newdate, newseats))!=null) {
				System.out.println("Event updated successfully!");
			} else {
				System.out.println("Failed to update event. Event with given id not found");
			}
			break;
			case 5:
				System.out.println("Logging out from Admin Menu.");
				return;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

	private void userMenu(Scanner scanner) {
		while (true) {
			System.out.println("\n--- User Menu ---");
			System.out.println("1. View Events");
			System.out.println("2. Register for Event");
			System.out.println("3. Sort Events By Date");
			System.out.println("4. Logout");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();

			switch (choice) {
			case 1:
				TreeSet<Event> events = eventsService.getAllEvents();
				if (events.isEmpty()) {
					System.out.println("No events found.");
				} else {

					for (Event event : events) {
						System.out.println(event);
					}
				}
				break;
			case 2:
				System.out.print("Enter Event ID to register: ");
				String eventId = scanner.next();
				System.out.println(eventsService.registerForEvent(eventId));
				break;

			case 3:
					TreeSet<Event> sortedEventsByDate = eventsService.getAllEventsSortedByDate();
					if (sortedEventsByDate ==null ) {
						System.out.println("No events found.");
					} else {

						for (Event event :sortedEventsByDate) {
							System.out.println(event);
						}
					}
					break;
			case 4:
				System.out.println("Logging out from User Menu.");
				return;

				
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}
}