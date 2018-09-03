package model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
	public static void main( String[] args )
    {
    	System.out.println("Hibernate one to one (XML mapping)");
    	Configuration cfg= new Configuration();
		 cfg.configure("resources/hibernate.cfg.xml");
		SessionFactory session= cfg.buildSessionFactory();
		Session s= session.openSession();
        s.beginTransaction();
        
        Passport passport= new Passport();
		passport.setPassportNumber("ABC123DD");
		
		PersonDetails pDetails= new PersonDetails();
		pDetails.setAddress("chennai");
		pDetails.setMobileNumber(11111111111111L);
		pDetails.setAge(22);
		
		PersonDetails pDetails1= new PersonDetails();
		pDetails1.setAddress("chennai");
		pDetails1.setMobileNumber(11111111111121L);
		pDetails1.setAge(22);
		
		List<PersonDetails> personal = new ArrayList<PersonDetails>();
		personal.add(pDetails);
		personal.add(pDetails1);
		
		Person person = new Person();
		person.setPersonName("stella");
		person.setEmail("stelladavies29@gmail.com");
        person.setPassport(passport);
		person.setPersonDetails(personal);
		s.save(passport);
     	s.save(person);
		s.getTransaction().commit();
		System.out.println("success");
	   }
}