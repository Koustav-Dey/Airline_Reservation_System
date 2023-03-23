package com.ars.service;

//ticket service interface

import java.time.LocalDate;

import com.ars.model.TicketBookingDTO;

public interface TicketService {
	TicketBookingDTO bookFlight(int flight_id,int no_of_passenger,LocalDate date,String pEmail,String airName);
	void cancelBooking(int id);
	TicketBookingDTO getTicket(int id);
}
