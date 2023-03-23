package com.ars;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ars.entity.Admin;
import com.ars.entity.Passenger;
import com.ars.model.PassengerDTO;
import com.ars.service.AdminService;
import com.ars.service.PassengerService;
import com.ars.serviceImpl.AdminServiceImpl;
import com.ars.serviceImpl.PassengerServiceImpl;


public class App 
{
    public static void main( String[] args )
    {
    	mainMenu();
    	
    	}
    static Scanner sc=new Scanner(System.in);
    public static void mainMenu()
    {
    	System.out.println("Press A for Admin\nPress U for Passenger\nPress Q for exit");
    	String choice=JOptionPane.showInputDialog("Enter choice","Type here");
    	switch(choice)
    	{
    	case "A":
    		mainAdmin();
    		break;
    	case "U":
    		mainUser();
    		break;
    	case "Q":
    		System.exit(0);
    	}
    }
    
    //this method responsible for registration and login of admin
    public static void mainAdmin() {
    AdminService aService=new AdminServiceImpl();
    String choice;
    while(true) {
    	System.out.println("Press R for registration\nPress L for Login\nPress Q for exit");
    	choice=JOptionPane.showInputDialog("Enter choice","Type here");
    	switch(choice)
    	{
    	case "R":
    		Admin admin=new Admin();
    		System.out.println("Enter the name: ");
    		String ad_name=sc.nextLine();
    		System.out.println("Enter the email: ");
    		String ad_email=sc.nextLine();
    		System.out.println("Enter the user name: ");
    		String ad_username=sc.nextLine();
    		System.out.println("Enter the password: ");
    		String ad_pass=sc.nextLine();
    		System.out.println("Enter the role: ");
    		String ad_role=sc.nextLine();
    		admin.setAName(ad_name);
          admin.setEmail(ad_email);
          admin.setUserName(ad_username);
          admin.setPassword(ad_pass);
          admin.setRole(ad_role);
          aService.registerAdmin(admin);
          System.out.println("Admin Registration done successfully");
    	case "L":
    		boolean status=aService.loginAdmin(JOptionPane.showInputDialog("Enter username","type here"),JOptionPane.showInputDialog("Enter password","Type here"));
        	if(status==true)
        		CrudOperation.AdminOperation();
        	else 
        		System.out.println("invalid credentials!!");
        	System.exit(0);
        	
        	break;
    	case "Q":
    		mainMenu();
       
    	}
    }
    }
    //this method responsible for registration and login  of passenger
    public static void mainUser() {
    	PassengerService pservice=new PassengerServiceImpl();
    	String choice;
        while(true) {
        	System.out.println("Press R for registration\nPress L for Login\nPress Q for exit");
        	choice=JOptionPane.showInputDialog("Enter choice","Type here");
        	switch(choice)
        	{
        	case "R":
        		Passenger passenger=new Passenger();
        		System.out.println("Enter the name: ");
        		String ps_name=sc.nextLine();
        		System.out.println("Enter the email: ");
        		String ps_email=sc.nextLine();
        		System.out.println("Enter the user name: ");
        		String ps_username=sc.nextLine();
        		System.out.println("Enter the password: ");
        		String ps_pass=sc.nextLine();
        		System.out.println("Enter the role: ");
        		String ps_role=sc.nextLine();
        		passenger.setName(ps_name);
              passenger.setEmail(ps_email);
              passenger.setUserName(ps_username);
              passenger.setPassword(ps_pass);
              passenger.setRole(ps_role);
              pservice.savePassenger(passenger);
              System.out.println("Passenger Registration done successfully");
        	case "L":
        		boolean status=pservice.login(JOptionPane.showInputDialog("Enter username","type here"),JOptionPane.showInputDialog("Enter password","Type here"));
            	if(status==true)
            		CrudOperation.crudOperation();
            	else {
            		System.out.println("invalid credentials!!");
            	System.exit(0);
            	}
            	break;
        	case "Q":
        		mainMenu();
           
        	}
    }
}
}
