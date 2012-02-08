package neu.edu.model;



import java.util.HashSet;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class Main extends HibernateDaoSupport {

	public static SessionFactory sessionFactory;
	
	public static void main (String[] args) {
		
		
		
		sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		
			
		Transaction transaction = null;
		try {
		transaction = session.beginTransaction();

			Major major1 = new Major("Engineering Software Design", "mourant");
			Major major2 = new Major("Information Systems", "Bugrara");
			Major major3 = new Major("Telecommunication Systems Management", "Peter");
			
			session.save(major1);
			session.save(major2);
			session.save(major3);
			

			
			Course courseNumber1 =new Course("Web Development",4, 20,null,null);
			Course courseNumber2 =new Course("Enterprise Software Development",4, 20,null,null);
			Course courseNumber3 = new Course("Database Managment", 4, 15,null,null);
			Course courseNumber4 = new Course("Mobile Wireless Computing", 4, 25, null,null);
			
	
			
			Set<Course> courses1=new HashSet<Course>();
			courses1.add(courseNumber1);
			
			Set<Course> courses2=new HashSet<Course>();
			courses2.add(courseNumber2);
			
			Set<Course> courses3=new HashSet<Course>();
			courses3.add(courseNumber3);
			courses3.add(courseNumber4);
			
		
			Instructor instructor1 = new Instructor("mourant","mourant@gmail.com","111",null);
			Instructor instructor2 = new Instructor("suneil","suneil@gmail.com","222",null);
			Instructor instructor3 = new Instructor("peter","peter@gmail.com","333",null);
			
			Student student1 = new Student("zack", "zhang.zhiyu86@gmail.com", "111", "M", "1986/09/28", null, "hello world", null, courses3);
			Student student2 = new Student("yu", "wiud@hotmail.com", "222","M", "1988/04/23", major2, "good morning", null, courses2);
			Student student3 = new Student("caiyun", "liucaiyun423@gmail.com","true", "F", "1986/06/12", major3,"thank you",null, courses1 );
			
			student1.setMajor(major1);
			
			
			
			session.save(courseNumber1);
			session.save(courseNumber2);
			
			
			session.save(instructor1);
			session.save(instructor2);
			session.save(instructor3);
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			
			
			/*courses3.remove(courseNumber3);
			 student1.setCourses(courses3);
*/	//		session.saveOrUpdate(student1);
			
	//		student3.setMajor(null);
			
	//		session.delete(major3);
			
			
			
			
			transaction.commit();
	     } catch (HibernateException e) {
	transaction.rollback();
	e.printStackTrace();
	} finally {
	session.close();
	}

	}

	}
