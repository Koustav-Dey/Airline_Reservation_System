package com.ars.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.PersistenceException;

import com.ars.entity.Flight;

//interfacer flightdao cured operation
public interface FlightDAO {
void saveFlight(Flight flight);
Flight updateFlight(int id,Flight flight);
Flight getFlight(int id);
void deleteFlight(int id)throws PersistenceException;
List<Flight> checkFlight(String from,String to,LocalDate date);

}
