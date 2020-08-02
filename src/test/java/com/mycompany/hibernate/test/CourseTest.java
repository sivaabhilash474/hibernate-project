package com.mycompany.hibernate.test;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.hibernate.beans.Course;

public class CourseTest {
	
	public static void main(String[] args) {
		
		Course c = new Course();
		c.setCourseID(1);
		c.setCourseName("Hibernate");
		c.setCourseFee(20);
		
		Configuration cfg = new Configuration();

		File file = new File("C:\\Users\\sivaa\\workspace\\com.mycompany.hibernate-project\\src\\main\\java\\resources\\hibernate.cfg.xml");
		file.exists();
		cfg.configure(file);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.save(c);
		session.beginTransaction().commit(); //Student object is moved to database
		System.out.println("Course Object Stored in the database successfully...");
		session.evict(c); 
	}

}
