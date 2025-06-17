package Railway_Ticket_Booking_System;

import java.util.*;

public class TicketBooking {
	
	public static void main(String[] args)
	{
		
		TicketSystem tickets = new TicketSystem();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nRailway Booking System -- >");
		
		while(true)
		{
			System.out.println();			
			System.out.println("1. Book tickets");
			System.out.println("2. Cancel tickets");
			System.out.println("3. View ConfirmedTickets");
			System.out.println("4. View AvailableTickets");
			System.out.println("5. View RAC tickets");
			System.out.println("6. View WaitingList ticktes");
			System.out.println("7. Exit");
			
			System.out.print("\nEnter a choice - > ");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice)
			{
			
				case 1 :
					
					System.out.print("\nEnter your Name : ");
					String name = sc.nextLine();
					
					System.out.print("Enter your Age : ");
					int age = sc.nextInt();
					sc.nextLine();
					
					System.out.print("Enter your Gender : ");
					String gender = sc.nextLine().toLowerCase();
					
					System.out.print("Enter your Birthprefernce(U, M, L) : ");
					String birthPrefer = sc.nextLine().toUpperCase();
					
					tickets.bookTickets(name,age,gender,birthPrefer);
					break;
				
				case 2 :
					
					System.out.print("\nEnter your ticket to delete : ");
					String delTicket = sc.nextLine();
					
					tickets.cancelTickets(delTicket);
					break;
					
					
				case 3 :
					
					tickets.viewAllConfirmedTickets();
					break;
					
				case 4 :
					
					tickets.viewAvailableTickets();
					break;
				
				case 5 :
					
					tickets.viewRACTickets();
					break;
				
				case 6 :
					
					tickets.viewWaitingListTickets();
					break;
					
				case 7 :
					
					System.out.print("\nExiting....");
					return;
					
				default :
					
					System.out.print("\nInvalid choice , Try again!");
					break;
			}
		}
	}
	
	
}
