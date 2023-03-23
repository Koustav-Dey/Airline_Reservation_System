package com.ars.service;

////flight service interface

import java.time.LocalDate;
import java.util.List;

import javax.persistence.PersistenceException;

import com.ars.entity.Flight;
import com.ars.model.FlightDTO;

public interface FlightService {
	void saveFlight(Flight flight);
	FlightDTO updateFlight(int id,Flight flight);
	FlightDTO getFlight(int id);
	void deleteFlight(int id)throws PersistenceException;
	List<Flight> checkFlight(String from,String to,LocalDate date);

}
