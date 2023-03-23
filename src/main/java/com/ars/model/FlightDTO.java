package com.ars.model;

//flight dto

import java.time.LocalDate;

import com.ars.entity.Airline;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class FlightDTO {
	private int flight_id;
	private int avilableSeats;
	private int totalSeats;
	private String travellerClass;
	private String time;
	private LocalDate date;
	private String source;
	private String destination;
	private Airline airline;

}
