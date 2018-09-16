package controller;

import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

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

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(cunanan);
		session.getTransaction().commit();

	}

}
