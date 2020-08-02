package com.mycompany.hibernate.test;

import java.io.File;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.mycompany.hibernate.beans.Student;

public class StudentTest {
	
	public static void main(String[] args) {
		
		Student s1 = new Student();
//		s1.setId(111);
//		s1.setName("siva");
//		s1.setEmail("siva@gmail.com");
//		s1.setMarks(555);
		
		Student s2 = new Student();
		s2.setId(112);
		s2.setName("pavan");
		s2.setEmail("pavan@gmail.com");
		s2.setMarks(450);
		
		// up to here the student object state is transient
		
		Configuration cfg = new Configuration();

		File file = new File("C:\\Users\\sivaa\\workspace\\com.mycompany.hibernate-project\\src\\main\\java\\resources\\hibernate.cfg.xml");
		file.exists();
		cfg.configure(file);
		SessionFactory sf = cfg.buildSessionFactory();
		Session session = sf.openSession();
		session.save(s2);
		//Student object state is persistent
		
		session.beginTransaction().commit(); //Student object is moved to database
		System.out.println("Object Stored in the database successfully...");
		session.evict(s2); //Student object will be detached from hibernate
		
		
		
		
		
	}

}
