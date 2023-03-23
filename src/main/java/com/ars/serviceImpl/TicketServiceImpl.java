package com.ars.serviceImpl;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;

import com.ars.dao.AirlineDao;
import com.ars.dao.FlightDAO;
import com.ars.dao.PassengerDAO;
import com.ars.dao.TicketDAO;
import com.ars.daoimpl.AirlineDAOImpl;
import com.ars.daoimpl.FlightDAOImpl;
import com.ars.daoimpl.PassengerDAOImpl;
import com.ars.daoimpl.TicketDAOImpl;
import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;
import com.ars.entity.TicketBooking;
import com.ars.exception.GlobalException;
import com.ars.model.TicketBookingDTO;
import com.ars.service.TicketService;

public class TicketServiceImpl implements TicketService{
	FlightDAO fdao=new FlightDAOImpl();
	AirlineDao adao=new AirlineDAOImpl();
	PassengerDAO pado=new PassengerDAOImpl();
	TicketDAO tdao=new TicketDAOImpl();
	
	@Override
	//save ticket
	public TicketBookingDTO bookFlight(int flight_id, int no_of_passenger, LocalDate date, String pEmail,String airName) {
	Flight flight=fdao.getFlight(flight_id);
	if(flight.getAvilableSeats()>no_of_passenger)
	{
		Passenger p=pado.getPassengerByEmail(pEmail);
		Airline airline=adao.getAirlineByName(airName);
		float totalFare=airline.getFare()*no_of_passenger;
		int avilable_seat=(flight.getAvilableSeats()-no_of_passenger);
		TicketBooking bookedTicket=tdao.bookFlight(airline, p, date, flight, no_of_passenger, totalFare, avilable_seat);
	return new ModelMapper().map(bookedTicket, TicketBookingDTO.class);
	}
		return null;
	}

	
	//cancel ticket
	@Override
	public void cancelBooking(int id) {
	tdao.cancelBooking(id);
		
	}

	@Override
	public TicketBookingDTO getTicket(int id) {
		TicketBooking tick=tdao.getTicket(id);
		if(tick!=null)
		{
			return new ModelMapper().map(tick, TicketBookingDTO.class);
		}

		throw new GlobalException("Passenger details not found");
	}

}
