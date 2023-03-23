

package com.ars;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import com.ars.entity.Admin;
import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;
import com.ars.entity.TicketBooking;
import com.ars.entity.TicketGenerationPdf;
import com.ars.model.AdminDTO;
import com.ars.model.AirlineDTO;
import com.ars.model.FlightDTO;
import com.ars.model.PassengerDTO;
import com.ars.model.TicketBookingDTO;
import com.ars.service.AdminService;
import com.ars.service.AirlineService;
import com.ars.service.FlightService;
import com.ars.service.PassengerService;
import com.ars.service.TicketService;
import com.ars.serviceImpl.AdminServiceImpl;
import com.ars.serviceImpl.AirlineServiceImpl;
import com.ars.serviceImpl.FlightServiceImpl;
import com.ars.serviceImpl.PassengerServiceImpl;
import com.ars.serviceImpl.TicketServiceImpl;

public class CrudOperation {
	static PassengerService pservice=new PassengerServiceImpl();
	static AdminService aservice=new AdminServiceImpl();
	static FlightService fservice=new FlightServiceImpl();
	static AirlineService aService=new AirlineServiceImpl();
	static TicketService tService=new TicketServiceImpl();
	static Scanner sc=new Scanner(System.in);
	//this method is responsible to perform crud of admin
	public static void crudAdmin()
	{
		String xx;
		while(true)
		{
			System.out.println("========================================");
			System.out.println("Press r To read admin\nPress u for "
					+ "update admin\nPress d for delete admin"
					+ "\nPress q for quit\n");
			System.out.println("========================================");
			xx=JOptionPane.showInputDialog("enter choice","type here");
			switch(xx)
			{
			case "r":
				try {
					AdminDTO aDto=aservice.getAdminById((Integer.parseInt(JOptionPane.showInputDialog("Enter admin id","type here"))));
					System.out.println("Admin detalis: ");
					System.out.println("id: "+aDto.getId());
					System.out.println("name: "+aDto.getAName());
					System.out.println("Email: "+aDto.getEmail());
					
				}catch (Exception e) {
					System.out.println(e);
				}
				break;
			case "u":
				
				Admin admin=new Admin();
				String name=JOptionPane.showInputDialog("Enter name","Type here");
				String email=JOptionPane.showInputDialog("Enter email","Type here");
				String uname=JOptionPane.showInputDialog("Enter user name","Type here");
				String pass=JOptionPane.showInputDialog("Enter password","Type here");
				admin.setAName(name);
				admin.setEmail(email);
				admin.setUserName(uname);
				admin.setPassword(pass);
				
				AdminDTO upadmin=aservice.updateAdmin(Integer.parseInt(JOptionPane.showInputDialog("Enter admin id to update","type here")),admin);
				System.out.println("Admin updated successfully");
				break;
			case "d":
				try {
					aservice.deleteAdmin(Integer.parseInt(JOptionPane.showInputDialog("Enter admin id to delete","type here")));
					JOptionPane.showMessageDialog(null, "object is deleted");
				} catch (PersistenceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case "q":
				CrudOperation.AdminOperation();
				break;
			}
			}
		
	}
	//this method is responsible to perform crud  operation of passenger
			public static void crudPassenger()
			{
				String xx;
				while(true) {
				System.out.println("============================================================================");
		System.out.println( "Press r. for read Passenger details\n Press u.for update Passenger details\n Press d.for delete Passenger details\n"
				+ " Press q for quit");
		System.out.println("============================================================================");
		 xx=JOptionPane.showInputDialog("Enter choice","Type here");

		 switch(xx) {
		 

		 case "r":
		
			try {

			
				PassengerDTO pDto=pservice.getPassengerById(Integer.parseInt(JOptionPane.showInputDialog("Enter id", "type here")));
				System.out.println("Passenger details: ");
				System.out.println("Id: "+pDto.getId());
				System.out.println("Name: "+pDto.getName());
		        System.out.println("Ph. No: "+pDto.getPhno());
		        System.out.println("Email: "+pDto.getEmail());
			}
			catch (Exception e) {
				System.out.println(e);
			}
			
		break;
			
		 case "u":
			 
			Passenger passenger=new Passenger();
			String name=JOptionPane.showInputDialog("Enter name for Update:","Type here");
			String email=JOptionPane.showInputDialog("Enter email for Update:","Type here");
			String phno=JOptionPane.showInputDialog("Enter Phone Number for Update:","Type here");
			String uname=JOptionPane.showInputDialog("Enter user_name for Update:","Type here");
			String pass=JOptionPane.showInputDialog("Enter password for Update:","Type here");
			
			passenger.setName(name);
			passenger.setEmail(email);
			passenger.setPhno(phno);
			passenger.setUserName(uname);
			passenger.setPassword(pass);
			
			PassengerDTO upPass=pservice.updatePassenger(Integer.parseInt(JOptionPane.showInputDialog("enter id to update", "type here")),
					passenger);
			System.out.println("Passenger updated successfully");
		break;	

		 case "d":
			 try {
			pservice.deletePassenger(Integer.parseInt(JOptionPane.showInputDialog("enter id to delete", "type here")));
			JOptionPane.showMessageDialog(null, "Object is deleted!!!!");
			 }catch(PersistenceException e)
			 {
				 System.out.println(e.getMessage());
			 }
			 break;

		 case "q":
			 crudOperation();
			 break;

		 }//end of switch
				}
			} //crud passenger
			
			//this method is responsible to perform crud  operation of flight
			public static void crudFlight()
			{
				String xx;
				while(true) {
				System.out.println("============================================================================");
		System.out.println( "Press c for create Flight\nPress r. for read Flight details\n Press u.for update Flight details\n Press d.for delete Flight details\n"
				+ " Press q for quit");
		System.out.println("============================================================================");
		 xx=JOptionPane.showInputDialog("Enter choice","Type here");

		 switch(xx) {
		 
		 case "c":
			 Flight flight3=new Flight();
			 System.out.println("Enter the avilable seats");
			 int aseat=sc.nextInt();
			 System.out.println("enter the total number of seats: ");
			 int tseat=sc.nextInt();
			 sc.nextLine();
			 System.out.println("Enter the traveller class: ");
			 String tclass=sc.nextLine();
			 System.out.println("Enter the time: ");
			 String t=sc.nextLine();
			 System.out.println("Enter the date: ");
			 String d1=sc.nextLine();
			 LocalDate date1=LocalDate.parse(d1);
			 System.out.println("Enter the source: ");
			 String fsource=sc.nextLine();
			 System.out.println("Enter the destination: ");
			 String fdest=sc.nextLine();
			 flight3.setAvilableSeats(aseat);
			 flight3.setTotalSeats(tseat);
			 flight3.setTravellerClass(tclass);
			 flight3.setTime(t);
			 flight3.setDate(date1);
			 flight3.setSource(fsource);
			 flight3.setDestination(fdest);
			 fservice.saveFlight(flight3);
			 System.out.println("flight added successfully");
			 break;
		 case "r":
		
			try {
				int id;
				System.out.println("enter id: ");
				id=sc.nextInt();
				FlightDTO fDto=fservice.getFlight(id);
				System.out.println("flight details: ");
				System.out.println("Id: "+fDto.getFlight_id());
				System.out.println("Avilable seates: "+fDto.getAvilableSeats());
		        System.out.println("Total seats: "+fDto.getTotalSeats());
		        System.out.println("Date: "+fDto.getDate());
		        System.out.println("Time: "+fDto.getTime());
		        System.out.println("Source: "+fDto.getSource());
		        System.out.println("Destination: "+fDto.getDestination());
		        System.out.println("Traveller class: "+fDto.getTravellerClass());
		        System.out.println("Airline id: "+fDto.getAirline());
		        
			}
			catch (Exception e) {
				System.out.println(e);
			}
		break;
		
		 case "u":
			 Flight f1=new Flight();
			 
			 System.out.println("Enter the avilable seats");
			 int a1seat=sc.nextInt();
			 System.out.println("enter the total number of seats: ");
			 int t1seat=sc.nextInt();
			 sc.nextLine();
			 System.out.println("Enter the traveller class: ");
			 String t1class=sc.nextLine();
			 System.out.println("Enter the time: ");
			 String t1=sc.nextLine();
			 System.out.println("Enter the date: ");
			 String d2=sc.nextLine();
			 LocalDate date2=LocalDate.parse(d2);
			 System.out.println("Enter the source: ");
			 String fsource1=sc.nextLine();
			 System.out.println("Enter the destination: ");
			 String fdest1=sc.nextLine();
			 f1.setAvilableSeats(a1seat);
			 f1.setTotalSeats(t1seat);
			 f1.setTravellerClass(t1class);
			 f1.setTime(t1);
			 f1.setDate(date2);
			 f1.setSource(fsource1);
			 f1.setDestination(fdest1);
			 
			
			 FlightDTO upflight=fservice.updateFlight(Integer.parseInt(JOptionPane.showInputDialog("Enter Flight id to update","type here")),f1);
				System.out.println("Flight updated successfully");
		 case "d":
				try {
					fservice.deleteFlight(Integer.parseInt(JOptionPane.showInputDialog("Enter Flight id to delete","type here")));
					JOptionPane.showMessageDialog(null, "Flight is deleted");
				} catch (PersistenceException e) {
					System.out.println(e.getMessage());
				}
		 case "q":
			 crudOperation();
			 break;

		 }//end of switch
				}
			} //crud flight
	//this method is responsible to assign flights to airline
	public static void assignAirlineToFlight()
	{
		System.out.println("Enter the id: ");
		int f_id=sc.nextInt();
		System.out.println("Enter the airline Id: ");
		int a_id=sc.nextInt();
		aService.assignAirlineToFlight(f_id, a_id);
		System.out.println("flight assign to airline successfully");
		
	}
	//this method is responsible to perform crud opr of airline
	public static void crudAirline()
	{
		String in;
		while(true)
		{
			System.out.println("===============================================");
			System.out.println("Press c.for add Airline\nPress r for get airline details\npress u for update airline\npress d for delete airline\npress q for quit");
			System.out.println("===============================================");
			System.out.println("enter your choice: ");
			in=sc.nextLine();
			switch(in)
			{
			case "c":
				Airline airline=new Airline();
				System.out.println("Enter the airline name: ");
				String a_name=sc.nextLine();
				System.out.println("Enter the fare: ");
				float a_fare=sc.nextFloat();
				airline.setAirlineName(a_name);
				airline.setFare(a_fare);
				aService.saveAirline(airline);
				System.out.println("Airline saved successfully");
				break;
			case "r":
				try {
					String name;
					System.out.println("Enter Airline Name :- ");
					name=sc.nextLine();
					AirlineDTO aDto=aService.getAirlineByName(name);
					System.out.println("Airline details: ");
					System.out.println("Airline Name :- "+aDto.getAirlineName());
					System.out.println("Fare :- "+aDto.getFare());
					System.out.println("Airline Id :- "+aDto.getId());
			        
				}
				catch (Exception e) {
					System.out.println(e);
				}
				
			case "u":
				Airline airline_up=new Airline();
				System.out.println("Enter the airline name: ");
				String au_name=sc.nextLine();
				System.out.println("Enter the fare: ");
				float au_fare=sc.nextFloat();
				airline_up.setAirlineName(au_name);
				airline_up.setFare(au_fare);
				AirlineDTO upairline=aService.updateAirlineById(Integer.parseInt(JOptionPane.showInputDialog("Enter Airline id to update","type here")),airline_up);
				System.out.println("Flight updated successfully");
			
			case "d":
				try {
					aService.deleteAirline(Integer.parseInt(JOptionPane.showInputDialog("Enter Airline id to delete","type here")));
					JOptionPane.showMessageDialog(null, "Airline is deleted");
				} catch (PersistenceException e) {
					System.out.println(e.getMessage());
				}
			case "q":
				AdminOperation();
			}//end of switch
			
		}//end of while loop
	}
	
	//this method is responsible for booking flights
	public static void bookFlight()
	{
		List<Flight> flights=fservice.checkFlight(JOptionPane.showInputDialog("Enter from","Type here"), JOptionPane.showInputDialog("Enter To","Type here"),LocalDate.parse(JOptionPane.showInputDialog("Enter date","Type here")));
		System.out.println("FlightId\tAirline Name\tFrom\tTo\tFare\tTiming\tDate");
		for(Flight flight:flights)
		{
			System.out.println(flight.getFlight_id()+"\t"+flight.getAirline().getAirlineName()+"\t"+flight.getSource()+"\t"+flight.getDestination()+"\t"+flight.getAirline().getFare()+"\t"+flight.getTime()+"\t"+flight.getDate());
		}
		System.out.println("For booking press yes");
		String choice=JOptionPane.showInputDialog("Enter here","Type here");
		if(choice.equalsIgnoreCase("yes"))
		{
		  int flight_id=Integer.parseInt(JOptionPane.showInputDialog("Enter flight id","type here"));
		  int no_of_passenger=Integer.parseInt(JOptionPane.showInputDialog("Enter number of passenger","type here"));
		  LocalDate date=LocalDate.parse(JOptionPane.showInputDialog("Enter date","type here"));
		  String pEmail=JOptionPane.showInputDialog("enter your email","type here");
		  String airName=JOptionPane.showInputDialog("Enter ailrine name","type here");
		  TicketBookingDTO ticketDTO=tService.bookFlight(flight_id, no_of_passenger, date, pEmail, airName);
		  System.out.println("your booking has done successfully");
		  TicketGenerationPdf.TicketGeneration(ticketDTO);
		}
	}
	// this method is responsible for check flight
	public static void checkFlights()
	{
		List<Flight> flights=fservice.checkFlight(JOptionPane.showInputDialog("Enter from","Type here"), JOptionPane.showInputDialog("Enter To","Type here"),LocalDate.parse(JOptionPane.showInputDialog("Enter date","Type here")));
		System.out.println("FlightId\tAirline Name\tFrom\tTo\tFare\tTiming\tDate");
		for(Flight flight:flights)
		{
			System.out.println(flight.getFlight_id()+"\t"+flight.getAirline().getAirlineName()+"\t"+flight.getSource()+"\t"+flight.getDestination()+"\t"+flight.getAirline().getFare()+"\t"+flight.getTime()+"\t"+flight.getDate());
		}
	}
	//this method is responsible for boarding pass
public static void boardingPass()
{
	System.out.println();
	TicketBookingDTO tDto=tService.getTicket(Integer.parseInt(JOptionPane.showInputDialog("Enter id","type here")));
	System.out.println("============================================================");
	System.out.println("Airways: "+tDto.getAirlineId().getAirlineName()+"\t\t BOARDING PASS");
	System.out.println("Ticket no: "+tDto.getTicketId());
	System.out.println(" Name: "+tDto.getPassengerId().getName()+"\t\tNo of Passenger "
			+tDto.getNo_of_passenger());
	System.out.println("From: "+tDto.getFlightid().getSource()+"\t\t"+tDto.getFlightid().getDestination());
	System.out.println("Flight: "+tDto.getFlightid().getFlight_id()+"\t\tDate: "+tDto.getFlightid().getDate());
	
System.out.println("====================================================================");
}
public static void crudOperation()
{
	int input;
	while(true)
	{
		System.out.println("=============================================");
		System.out.println("1.Passenger details\n2.check flight\n3.book flight\n4.cancel booking\n5.get boarding pass\n6.quit");
		input=Integer.parseInt(JOptionPane.showInputDialog("Enter choice","type here"));
		System.out.println("=============================================");
		switch(input)
		{
		case 1:
			crudPassenger();
			break;
		case 2:
			checkFlights();
			break;
		case 3:
			bookFlight();
			break;
		case 4:
			System.out.println("Enter your ticket id: ");
			int id=sc.nextInt();
			tService.cancelBooking(id);
			JOptionPane.showMessageDialog(null,"Objectis deleted!!!");
			break;
		case 5:
			boardingPass();
			break;
		case 6:
			App.mainMenu();
			break;
		}
	}
	}
//this method is used for admin operation like flight crud,airline crud,add flight to airline
public static void AdminOperation()
{
	int input;
	while(true)
	{
		System.out.println("=============================================");
		System.out.println("1.Flight details\n2.airline details\n3.add flight to airline\n4.admin crud\n5.quit");
		input=Integer.parseInt(JOptionPane.showInputDialog("Enter choice","type here"));
		System.out.println("=============================================");
		switch(input)
		{
		case 1:
			crudFlight();
			break;
		case 2:
			crudAirline();
			break;
		case 3:
			assignAirlineToFlight();
			break;
		case 4:
			crudAdmin();
			break;
		case 5:
			App.mainMenu();
		}
	}
	}
}

