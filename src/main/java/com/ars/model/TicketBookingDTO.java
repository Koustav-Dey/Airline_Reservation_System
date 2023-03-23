package com.ars.model;

//ticketing booking dto

import java.util.Date;

import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketBookingDTO {
private int ticketId;
private int no_of_passenger;
private Date date=new Date();
private Flight flightid;
private Airline airlineId;
private Passenger passengerId;


}
