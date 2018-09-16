package controller;

import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Address;
import model.HomeAddress;

public class AccessStudent {

	public static void main(String[] args) {
		Student cunanan = new Student();
		cunanan.setId(2014069410);
		cunanan.setLastName("Cunanan");
		cunanan.setFirstName("Patrick");
		cunanan.setYearLevel(3);
		cunanan.setCourse("BS in CS");
		cunanan.setAmbition("To graduate");
		cunanan.setEnrolled(new java.util.Date());

		Address lokasyonNgPaaralan = new Address();
		lokasyonNgPaaralan.setNumber(123);
		lokasyonNgPaaralan.setStreet("Espana Blvd.");
		lokasyonNgPaaralan.setCity("Manila");
		lokasyonNgPaaralan.setZipCode(1611);
		lokasyonNgPaaralan.setRegion("NCR");
		lokasyonNgPaaralan.setCountry("Philippines");
		
		cunanan.setSchoolAddress(lokasyonNgPaaralan);
		
		HomeAddress homeAdd = new HomeAddress();
		homeAdd.sethNumber(55);
		homeAdd.sethStreet("Sampaguita St.");
		homeAdd.sethCity("Valenzuela");
		homeAdd.sethZipCode(1440);
		homeAdd.sethRegion("NCR");
		homeAdd.sethCountry("Philippines");
		
		
		cunanan.setHomeAddress(homeAdd);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(cunanan);
		session.getTransaction().commit();

	}

}
