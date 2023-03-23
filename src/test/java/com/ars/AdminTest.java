package com.ars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ars.config.HibernateUtil;
import com.ars.entity.Admin;
import com.ars.model.AdminDTO;
import com.ars.service.AdminService;
import com.ars.serviceImpl.AdminServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AdminTest {
	AdminService adminService=new AdminServiceImpl();
	private static SessionFactory sessionFactory;
	private Session session;
	
	@BeforeAll
	static void setUp() {
		sessionFactory=HibernateUtil.getSessionFactory();
	}
	
	@BeforeEach
	void openSession() {
		session=sessionFactory.openSession();
	}
	
	@AfterEach
	void closeSession() {
		if(session!=null)
			sessionFactory.close();
		System.out.println("Session factory closed");
	}
	
	//testing for admin
	//data insert
	
	@Test
	@Order(1)
	void testRegisterAdmin()
	{
		Transaction tx=session.beginTransaction();
		Admin admin=Admin.builder().aName("Mangal").email("mangaldip124@gmail.com").UserName("mangal124").password("124").role("ADMIN").build();
		Integer i=(Integer)session.save(admin);
		tx.commit();
		assertThat(i>0).isTrue();
		System.out.println("Data add successfully");
		}
	
	// admin update
	
//	@Test
//	@Order(2)
//	void testGetAdminById(){
//		AdminDTO adto=adminService.getAdminById(4);
//		assertThat(adto.getAName()).isEqualTo("Mangal");
//	}
	
	//update admin using service
	
//	@Test
//	@Order(3)
//	void testUpdateAdminUsingService()
//	{
//		Transaction tx=session.beginTransaction();
//		Admin ad=new Admin();
//		ad.setAName("Mangaldip Ghosh");
//		ad.setEmail("ghoshmangaldip1999@gmail.com");
//		ad.setUserName("mangaldip124");
//		ad.setPassword("man124");
//		AdminDTO adto=adminService.updateAdmin(4, ad);
//		tx.commit();
//		assertThat(adto.getAName()).isEqualTo("Mangaldip Ghosh");
//		}
	
	//admin delete
//	
//	@Test
//	@Order(4)
//	@DisplayName(value="Negetive Test case")
//	void testDeleteAdmin()
//	{
//		adminService.deleteAdmin(5);
//		assertThrows(HibernateException.class,()->adminService.getAdminById(5));
//		}

}
