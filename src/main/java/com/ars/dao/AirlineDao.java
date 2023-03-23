package com.ars.dao;

import javax.persistence.PersistenceException;

import com.ars.entity.Airline;

//interfacer airlinedao cured operation
public interface AirlineDao {
	void saveAirline(Airline airline);
	void assignAirlineToFlight(int flightId,int airId);
	Airline getAirlineByName(String name);
	Airline updateAirlineById(int id,Airline airline);
	void deleteAirline(int id)throws PersistenceException;
	

}
