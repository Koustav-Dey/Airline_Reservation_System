package com.ars.model;

//passengerdto

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDTO extends UserDTO{
	private String name;
	private String phno;
	private String email;
	

}
