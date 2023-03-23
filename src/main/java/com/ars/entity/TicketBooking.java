package com.ars.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name="ticket_booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//ticket booking
public class TicketBooking {
	@Id
	@GenericGenerator(name="ticket_no",strategy = "com.ars.entity.TicketNoGenerator")
	@GeneratedValue(generator="ticket_no")
	private int ticketId;
	private int no_of_passenger;
	private float total_fare;
	private LocalDate date=LocalDate.now();
	@OneToOne
	private  Flight id;
	@OneToOne
	private Airline aid;
	@OneToOne
	private Passenger pid;

}
