package com.ars.dao;

import javax.persistence.PersistenceException;

import com.ars.entity.Admin;

//interfacer admin dao cured operation
public interface AdminDAO {
	void registerAdmin(Admin admin);
	boolean loginAdmin(String userName,String password);
	Admin getAdminById(int id);
	void deleteAdmin(int id) throws PersistenceException;
	Admin updateAdmin(int id, Admin admin);

}
