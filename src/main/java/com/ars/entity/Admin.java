package com.ars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
//lombok constructor
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="register_admin")
//admin calss to user
public class Admin extends User{
	@Column(name = "admin_name",length = 50)
	private String aName;
	@Column(length = 50)
	private String email;
	
	//this is for junit testing
	@Builder
	public Admin(int id,String UserName, String password,String role,String aName,String email) {
		super(id,UserName,password,role);
		this.aName = aName;
		this.email = email;
	}
	

}
