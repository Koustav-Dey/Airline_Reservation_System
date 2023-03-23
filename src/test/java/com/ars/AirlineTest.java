package com.ars;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ars.config.HibernateUtil;
import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.model.AirlineDTO;
import com.ars.service.AirlineService;
import com.ars.serviceImpl.AirlineServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AirlineTest {

	AirlineService airlineService=new AirlineServiceImpl();
	private static SessionFactory sessionFactory;
	private Session session;
	
	@BeforeAll
	static void setUp() {
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	
	@BeforeEach
	void openSession() {
		session=sessionFactory.openSession();
	}
	
	@AfterEach
	void closeSession() {
		if(session!=null)
			sessionFactory.close();
		System.out.println("Session factory closed");
	}
	
	@Test
	@Order(1)
	void AirlineService() {
		Transaction tx=session.beginTransaction();
		Airline airline =  Airline.builder().airlineName("Idgo").fare(5000).id(125).build();
		Integer i=(Integer)session.save(airline);
		tx.commit();
		assertThat(i>0).isTrue();
	}
	
//	void oneToManyRelationshipTest()
//	{
//		Airline airline=Airline.builder().airlineName("Air India").fare(2300).build();
//		
//		
//		Flight flight1=Flight.builder().airline(airline).avilableSeats(10).destination("delhi").source("kolkata").time("06:10").travellerClass("economy").date(LocalDate.of(2023, 03, 18)).build();
//		Flight flight2=Flight.builder().airline(airline).avilableSeats(10).destination("mumbai").source("kolkata").time("05:10").travellerClass("business").date(LocalDate.of(2023, 03, 18)).build();
//	
//		List<Flight> flights=new ArrayList()<Flight>();
//		flights.add(flight1);
//		flights.add(flight2);
//		airline.setFlights(flights);
//		flightService.saveFlight(flight1);
//		flightService.saveFlight(flight2);
//		
//		assertThat(flight1.getAirline()).isEqualTo(airline);
//		assertThat(flight2.getAirline()).isEqualTo(airline);
//		
//		
//		assertThat(airline.getFlights().get(0).getFlight_id()).isEqualTo(flight1.getFlight_id());
//		assertThat(airline.getFlights().get(1).getFlight_id()).isEqualTo(flight2.getFlight_id());
//	}
	
	
	
}
