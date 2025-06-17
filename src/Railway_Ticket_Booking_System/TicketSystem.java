package Railway_Ticket_Booking_System;

import java.util.*;

public class TicketSystem {
	
	private final List<String> AvailableBirth = new ArrayList<>(Arrays.asList("U","M","L"));
	
	private final Queue<Passenger> racList = new LinkedList<>();
	
	private final Queue<Passenger> waitingList = new LinkedList<>();
	
	private final List<Passenger> confirmedPassengers = new ArrayList<>();
	
	private static int ticketCount = 1;
	
	
	void bookTickets(String name , int age , String gender , String birthPrefernce)
	{
		String ticket_id = "T-"+ticketCount++;
		
		Passenger passenger;
		
		if(!AvailableBirth.isEmpty())
		{
			String allotBirth = allotedBirth( age , gender , birthPrefernce);
			
			passenger = new Passenger(name,age,gender,birthPrefernce,allotBirth,ticket_id);
			
			AvailableBirth.remove(allotBirth);
			
			confirmedPassengers.add(passenger);
			
			System.out.print("\nTicket confirmed : "+passenger);
		}

		else if(racList.size()<1)
		{
			passenger = new Passenger(name,age,gender,birthPrefernce,"RAC",ticket_id);
			
			racList.add(passenger);
			
			System.out.print("\nTicket in RAC : "+passenger);;
		}
		else if(waitingList.size()<1)
		{
			passenger = new Passenger(name,age,gender,birthPrefernce,"Waiting",ticket_id);
			
			waitingList.add(passenger);
			
			System.out.print("\nTicket in waiting: "+passenger);
		}
		else
		{
			System.out.print("\nNo tickets available --");
		}
		
	}
	
	void cancelTickets(String ticket_id)
	{
		Optional<Passenger> passengerOpt = confirmedPassengers.stream().filter(p->p.ticket_id.equals(ticket_id)).findFirst();
		
		if(passengerOpt.isPresent())
		{
			Passenger passenger = passengerOpt.get();
			
			AvailableBirth.add(passenger.allotedBirth);
			
			confirmedPassengers.remove(passenger);
			
			if(!racList.isEmpty())
			{
				Passenger racPassenger = racList.poll();
				
				String allotBirth = allotedBirth(racPassenger.age , racPassenger.gender , racPassenger.birthpreference);
				
				racPassenger.allotedBirth = allotBirth;
				
				Passenger racPassengers = new Passenger(racPassenger.name , racPassenger.age , racPassenger.gender , racPassenger.birthpreference ,
						racPassenger.allotedBirth, racPassenger.ticket_id );
				
				confirmedPassengers.add(racPassengers);
				
				AvailableBirth.remove(racPassengers.allotedBirth);
				
				System.out.println("RAC ticket moved to confirmed: "+racPassengers);
				
			}
			if(!waitingList.isEmpty())
			{
				Passenger waitPassenger = waitingList.poll();
				
				waitPassenger.allotedBirth = "RAC";
				
				Passenger waitPassengers = new Passenger(waitPassenger.name , waitPassenger.age , waitPassenger.gender , waitPassenger.birthpreference ,
						waitPassenger.allotedBirth, waitPassenger.ticket_id );
				
				System.out.println("Waiting ticket moved to confirmed: "+waitPassengers);
			}
			System.out.print("\n Ticket Cancelled Successfully on id - "+ticket_id);
		}
		else
		{
			System.out.print("\nNo tickets found on id - "+ticket_id);
		}
	}
	
	void viewAllConfirmedTickets()
	{
		if(confirmedPassengers.isEmpty()) 
		{
			System.out.print("\nNo tickets found - -\n");
		}
		else
		{
			for(Passenger passenger : confirmedPassengers)
			{
				System.out.print(passenger);
			}
		}
	}
	
	void viewAvailableTickets()
	{
		System.out.print("\nConfirmedTickets : "+confirmedPassengers.size());
		System.out.print("\nRAC ticktes      : "+ (1- racList.size()));
		System.out.print("\nWaiting ticktes  : "+ (1- waitingList.size()));
	}
	
	void viewRACTickets()
	{
		if(racList.isEmpty()) 
		{
			System.out.print("\nNo RAC tickets found - -\n");
		}
		else
		{
			for(Passenger passenger : racList)
			{
				System.out.print(passenger);
			}
		}
	}
	
	void viewWaitingListTickets()
	{
		if(waitingList.isEmpty()) 
		{
			System.out.print("\nNo WaitingList tickets found - -\n");
		}
		else
		{
			for(Passenger passenger : waitingList)
			{
				System.out.print(passenger);
			}
		}
	}
	
	String allotedBirth(int age , String gender , String birthPrefer)
	{
		if(age>60 || gender.equalsIgnoreCase("female") && AvailableBirth.contains("L")) return "L";
		
		else if(AvailableBirth.contains(birthPrefer)) return birthPrefer;
		
		return AvailableBirth.get(0);
	}
}
