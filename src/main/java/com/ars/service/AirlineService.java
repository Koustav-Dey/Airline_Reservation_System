package com.ars.service;

////flight interface

import java.util.List;

import javax.persistence.PersistenceException;

import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.model.AirlineDTO;

import lombok.Builder;




public interface AirlineService {
	
	void saveAirline(Airline airline);
	void assignAirlineToFlight(int flightId,int airId);
	AirlineDTO getAirlineByName(String name);
	AirlineDTO updateAirlineById(int id,Airline airline);
	void deleteAirline(int id)throws PersistenceException;

}
