package com.ars.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//lombok for construcor and getter and setter
@Entity
@Table(name="Airlines")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//junit testing fopr builder
//airline class extends for user
public class Airline {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="airline_name",length = 50)
	private String airlineName;
	private float fare;
	@OneToMany(mappedBy = "airline",cascade = CascadeType.ALL)
	List<Flight>flights;
}
