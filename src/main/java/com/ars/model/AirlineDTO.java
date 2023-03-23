package com.ars.model;

import java.util.List;

import com.ars.entity.Flight;

import lombok.Data;

//airlinedto

@Data
public class AirlineDTO {
	private int id;
	private String airlineName;
	private float fare;
	List<Flight> flights;

}
