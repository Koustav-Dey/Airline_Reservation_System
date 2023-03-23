package com.ars.daoimpl;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ars.config.HibernateUtil;
import com.ars.dao.AdminDAO;
import com.ars.entity.Admin;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public void registerAdmin(Admin admin) {
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		session.close();
		
	}

	@Override
	public boolean loginAdmin(String userName, String password) {
		Session session=HibernateUtil.getSession();
		Admin admin=session.get(Admin.class,1);
		if(admin.getUserName().equals(userName) && admin.getPassword().equals(password))
			return true;
		else
		return false;
	}
	//method for get admin in DAO layer
		@Override
		public Admin getAdminById(int id) {
			try(Session session=HibernateUtil.getSession()){
				Admin admin=(Admin)session.get(Admin.class, id);
				
				return admin;
				
				}
				
			catch (HibernateException e) {
				System.out.println("hibernate exception is: "+ e);
			}
				
			catch (Exception e) {
				System.out.println("exception is: "+ e);
			}
				return null;
		}
		//method for delete admin in DAO layer
		@Override
		public void deleteAdmin(int id) throws PersistenceException {
			try(Session session=HibernateUtil.getSession()){
				Admin ad=session.load(Admin.class, id);
				
				session.beginTransaction();
				int input=JOptionPane.showConfirmDialog(null, "Do you want to delete?",
						"select what you want to delete or not?",JOptionPane.YES_NO_OPTION);
					
				if(input==0)
				{
					session.delete(ad);
				}
				else
				JOptionPane.showMessageDialog(null, "User wants to retain it!!!");
				session.getTransaction().commit();
				
				}catch (HibernateException e) {
					System.out.println("hibernate exception is: "+ e);
				}
					
				catch (PersistenceException e) {
					System.out.println("You cannot delete your account as you have a booking with us.");
				}
		}
		//method for Update admin  in DAO layer
		@Override
		public Admin updateAdmin(int id, Admin admin) {
			try(Session session=HibernateUtil.getSession()){
				Admin adm=(Admin)session.load(Admin.class, id);
				
				//update existing details with new one
				adm.setAName(admin.getAName());
				adm.setEmail(admin.getEmail());	
				adm.setUserName(admin.getUserName());
				adm.setPassword(admin.getPassword());
				
				session.beginTransaction();
				session.saveOrUpdate(adm);
				session.getTransaction().commit();
				
				return adm;// return passenger entity
				}
				catch (HibernateException e) {
					System.out.println("hibernate exception is: "+ e);
				}
					
				catch (Exception e) {
					System.out.println("exception is: "+ e);
				}
			return null;
		}

}
