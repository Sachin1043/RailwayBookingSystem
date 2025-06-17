package Railway_Ticket_Booking_System;

public class Passenger {
	
	String name;
	
	int age;
	
	String gender;
	
	String birthpreference;
	
	String allotedBirth;
	
	String ticket_id;

	public Passenger(String name, int age, String gender, String birthpreference, String allotedBirth,
			String ticket_id) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.birthpreference = birthpreference;
		this.allotedBirth = allotedBirth;
		this.ticket_id = ticket_id;
	}
	
	public String toString()
	{
		return "\n---------------\nTicket_id : "+ticket_id + "\nName : "+name +"\nAge : "+age +"\nGender : "+gender +"\nBirthprefernce : "+birthpreference
				+"\nallotedBirth : "+allotedBirth+"\n---------------\n";
	}
}
