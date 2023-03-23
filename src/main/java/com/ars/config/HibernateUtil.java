package com.ars.config;

import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.ars.entity.Admin;
import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;
import com.ars.entity.TicketBooking;
import com.ars.entity.User;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
			try {
				//dartabase connection ,driver,settings
				Configuration configuration=new Configuration();
				Properties settings=new Properties();
				settings.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
				settings.put(Environment.URL,"jdbc:mysql://localhost:8080/air_res");
				settings.put(Environment.USER,"root");
				settings.put(Environment.PASS,"root");
				settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL8Dialect");
				settings.put(Environment.SHOW_SQL,"true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS,"thread");
				settings.put(Environment.HBM2DDL_AUTO,"update");
				settings.put(Environment.ENABLE_LAZY_LOAD_NO_TRANS,"true");
				configuration.setProperties(settings);
				
				//add annotated calss
				configuration.addAnnotatedClass(Admin.class);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Passenger.class);
				configuration.addAnnotatedClass(Flight.class);
				configuration.addAnnotatedClass(Airline.class);
				configuration.addAnnotatedClass(TicketBooking.class);
				
				
				ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().
						applySettings(configuration.getProperties()).build();
				System.out.println("hibernate java config seviceRegistry created");
				sessionFactory=configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;
			}catch(HibernateException e)
			{
				System.out.println(e.getMessage());
			}
		}
		return sessionFactory;
	}
	//open session
	public static Session getSession()
	{
		return getSessionFactory().openSession();
	}

}
