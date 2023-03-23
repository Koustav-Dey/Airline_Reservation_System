package com.ars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ars.config.HibernateUtil;
import com.ars.entity.Passenger;
import com.ars.model.PassengerDTO;
import com.ars.service.PassengerService;
import com.ars.serviceImpl.PassengerServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PassengerTest {
	PassengerService pservice=new PassengerServiceImpl();
	private static SessionFactory sessionFactory;
	private Session session;
	
	@BeforeAll
	static void setUp()
	{
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	@BeforeEach
	void openSession()
	{
		session=sessionFactory.openSession();
	}
	
@AfterEach
void closeSession()
{
	if(session!=null)
	session.close();
	System.out.println("Session closed");
	}
@AfterAll
static void tearDown()
{
	if(sessionFactory!=null)
		sessionFactory.close();
	System.out.println("Session factory colosed");
	}

//test passenger data insert
//test case 1
//	@Test
//	@Order(1)
//	void testRegisterPassenger() {
//		Transaction tx=session.beginTransaction();
//		Passenger passenger=Passenger.builder().name("Pradip").email("pradip@124").password("pradip@1240").UserName("pradip@gmqai").phno("98567458").role("PASSENGER").build();
//		Integer i=(Integer)session.save(passenger);
//		tx.commit();
//		assertThat(i>0).isTrue();
//	}

// getid by Passenger

//@Test
//@Order(2)
//void testGetPassengerById(){
//	PassengerDTO adto=pservice.getPassengerById(7);
//	assertThat(adto.getName()).isEqualTo("Pradip");
//}

//update id Passenger

//@Test
//@Order(3)
//void testUpdatePassengerUsingService()
//{
//	Transaction tx=session.beginTransaction();
//	Passenger ad=new Passenger();
//	ad.setName("Pradip Bauri");
//	ad.setEmail("pradipbauri124@gmail.com");
//	ad.setUserName("pradip124");
//	ad.setPassword("pradip124");
//	ad.setPhno("6294769356");
//	ad.setRole("PASSENGER");
//	PassengerDTO adto=pservice.updatePassenger(7, ad);
//	tx.commit();
//	assertThat(adto.getName()).isEqualTo("Pradip Bauri");
//	}

	
//delete id by passenger

//@Test
//@Order(4)
//@DisplayName(value="Negetive Test case")
//void testDeleteAdmin()
//{
//	pservice.deletePassenger(7);
//	assertThrows(HibernateException.class,()->pservice.getPassengerById(7));
//	}
}
