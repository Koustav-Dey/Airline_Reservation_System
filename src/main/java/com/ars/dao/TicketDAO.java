package com.ars.dao;

import java.time.LocalDate;

import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;
import com.ars.entity.TicketBooking;

//interfacer ticketdao cured operation
public interface TicketDAO {
	TicketBooking bookFlight(Airline airline,Passenger p,LocalDate date,Flight f,int no_of_passenger,float total_fare,int avilable_seat);
	void cancelBooking(int id);
	TicketBooking getTicket(int id);
}
