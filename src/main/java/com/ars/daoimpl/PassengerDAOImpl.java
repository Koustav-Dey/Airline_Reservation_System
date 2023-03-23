package com.ars.daoimpl;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.ars.config.HibernateUtil;
import com.ars.dao.PassengerDAO;
import com.ars.entity.Passenger;

public class PassengerDAOImpl implements PassengerDAO{

	@Override
	public void savePassenger(Passenger passenger) {
		try(Session session=HibernateUtil.getSession())
		{
			session.beginTransaction();
			session.save(passenger);
			session.getTransaction().commit();
			session.clear();
		}catch (HibernateException e) {
			System.out.println(e.getMessage());
		}
		
	}

	@Override
	public boolean login(String userName, String password) {
		Session session=HibernateUtil.getSession();
		Passenger p=session.get(Passenger.class,Integer.parseInt(JOptionPane.showInputDialog("enter id","type here")));
		if(p.getUserName().equals(userName) && p.getPassword().equals(password))
			return true;
		else
		return false;
	}

	@Override
	public Passenger getPassenger(int id) {
		try(Session session=HibernateUtil.getSession()){
			Passenger passenger=(Passenger)session.get(Passenger.class, id);
		return passenger;
		}catch (HibernateException e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Passenger updatePassenger(int id, Passenger passenger) {
		try(Session session=HibernateUtil.getSession())
		{
			Passenger pass=(Passenger)session.load(Passenger.class, id);
			pass.setName(passenger.getName());
			pass.setEmail(passenger.getEmail());
			pass.setPhno(passenger.getPhno());
			pass.setUserName(passenger.getUserName());
			pass.setPassword(passenger.getPassword());
			
			session.beginTransaction();
			session.saveOrUpdate(pass);
			session.getTransaction().commit();
			return pass;
			
		}catch (HibernateException e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public void deletePassenger(int id) throws PersistenceException {
		try(Session session=HibernateUtil.getSession())
		{
			Passenger passn=session.load(Passenger.class,id);
			session.beginTransaction();
			session.delete(passn);
			session.getTransaction().commit();
		}catch (HibernateException e) {
			System.out.println(e);
		}
		
	}

	@Override
	public Passenger getPassengerByEmail(String email) {
		try(Session session=HibernateUtil.getSession())
		{
			String query="from Passenger p where p.email=:e";
			Query q=session.createQuery(query);
			q.setParameter("e", email);
			Passenger p=(Passenger)q.uniqueResult();
			return p;
		}catch (HibernateException e) {
			System.out.println("hibernate exception"+e);
		}catch (Exception e) {
			System.out.println("Exception: "+e);
		}
		return null;
	}
	
}
