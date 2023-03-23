package com.ars.serviceImpl;

import javax.persistence.PersistenceException;

import org.modelmapper.ModelMapper;

import com.ars.dao.AirlineDao;
import com.ars.daoimpl.AirlineDAOImpl;
import com.ars.entity.Airline;
import com.ars.exception.GlobalException;
import com.ars.model.AirlineDTO;
import com.ars.service.AirlineService;


public class AirlineServiceImpl implements AirlineService {
AirlineDao airlineDAO=new AirlineDAOImpl();
	@Override
	//ailine data insert
	public void saveAirline(Airline airline) {
		airlineDAO.saveAirline(airline);
		
	}

	@Override
	
	//asigin flight for airline flight id & air id
	public void assignAirlineToFlight(int flightId, int airId) {
		airlineDAO.assignAirlineToFlight(flightId, airId);
		
	}

	@Override
	//getairline by name
	public AirlineDTO getAirlineByName(String name)throws GlobalException {
		Airline airline=airlineDAO.getAirlineByName(name);
		if(airline!=null)
		{
			return new ModelMapper().map(airline, AirlineDTO.class);
		}
		throw new GlobalException("Airline details not exist!!");
	}

	@Override
	//update airline by name
	public AirlineDTO updateAirlineById(int id, Airline airline) {
		Airline a=airlineDAO.updateAirlineById(id, airline);
		return new ModelMapper().map(a, AirlineDTO.class);
	}

	@Override
	//delete airline
	public void deleteAirline(int id) throws PersistenceException {
		airlineDAO.deleteAirline(id);
		
	}

}
