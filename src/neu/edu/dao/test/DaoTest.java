package neu.edu.dao.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import neu.edu.dao.CourseDao;
import neu.edu.dao.InstructorDao;
import neu.edu.dao.MajorDao;
import neu.edu.dao.StudentDao;
import neu.edu.model.Course;
import neu.edu.model.Instructor;
import neu.edu.model.Major;
import neu.edu.model.Student;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DaoTest {

	/**
	 * @param args
	 */
	
	
	public static void main(String[] args) {
		
		 Resource res = new ClassPathResource("beans.xml");
		 BeanFactory factory = new XmlBeanFactory(res);
		 MajorDao majorDao = (MajorDao)factory.getBean("majorDao");
		 StudentDao studentDao = (StudentDao)factory.getBean("studentDao");
    	 InstructorDao instructorDao = (InstructorDao)factory.getBean("instructorDao");
		 CourseDao courseDao = (CourseDao)factory.getBean("courseDao");
		 

		 Major major = new Major("Electrical Engineering","Paul");
		
//test getMajors()
		 List<Major> list1= majorDao.getMajors();
		 for(Major item : list1)
		 {System.out.println(item.getMajorName());}
		 System.out.println();
		 
		 

		
		   
//test getMajor()
	
		 
		
		   System.out.println(majorDao.getMajor(new Long(1)).getAdvisor());
		   System.out.println();
		   
//test getMajorForStudnet()
		   System.out.println(majorDao.getMajorForStudent(new Long(1)).getMajorName());
		   
           System.out.println("1----------------------------------------------------------------------");
           

//test getStudent()
		   
		   System.out.println(studentDao.getStudent(new Long(2)).getMajor().getMajorName());
		   System.out.println();
		   
// save student()
		 /*  Student student = new Student("freddy", "zhang@gmail.com", "666", false, "1986/02/22", null, "hello", null, null);
		   student.setMajor(major);
		   studentDao.saveStudent(student);*/
		   
// test getStudents()
		   List<Student> list2 = studentDao.getStudents();
	       for(Student item : list2){System.out.println(item.getStudentName());};
	       System.out.println();
	       
//  test getStudentsForCourse()
	       System.out.println(studentDao.getStudentsForCourse(new Long(1)).size());
	       
// test validateStudent()
	       
	       /*List<Student> list3 = studentDao.validateStudent("zhang.zhiyu86@gmail.com");
	       for(Student item : list3){System.out.println(item.getStudentName());}
	       System.out.println();*/
	       

	       
	      System.out.println("2----------------------------------------------------------------------");      
	

//	   	test getInstructor()	       
	       System.out.println(instructorDao.getInstructor(new Long(1)).getInstructorName());
	       
//	       test getInstructors()
	       List<Instructor> list4 = instructorDao.getInstructors();
	       for(Instructor item : list4){System.out.println(item.getInstructorName());};
	       System.out.println();
	       
	       
//test validatInstructor()
	       
	       
	       List<Instructor> list5 = instructorDao.validateInstructor("mourant@gmail.com");
	       for(Instructor item : list5){System.out.println(item.getInstructorName());}
	       System.out.println();
	       
//test getInstructorForCourse()
	       
	    
	       System.out.println(instructorDao.getInstructorForCourse(new Long(1)).getInstructorName());
	       System.out.println();
		   
	       System.out.println("3----------------------------------------------------------------------");	
	       
//test getCourse()
	       System.out.println(courseDao.getCourse(new Long(1)).getCourseName());
	       
//test getCoursesForInstructor()
		   List <Course> list7 = courseDao.getCoursesForInstructor(new Long(1));
		   for(Course item: list7){ System.out.println(item.getCourseName());}
		   System.out.println();
		   
// test getCoutsesForStudent()
		   List <Course> list8 = courseDao.getCoursesForStudent(new Long(1));
		   for(Course item: list8){ System.out.println(item.getCourseName());}
		   System.out.println();
		   
// test getCourses()
		   List <Course> list9 = courseDao.getCourses();
		   for(Course item: list9){ System.out.println(item.getCourseName());}
		   System.out.println();
	       System.out.println("4----------------------------------------------------------------------");
//test searchCourseByName()
	       List <Course> list10 = courseDao.searchCoursesByName("0");
		   for(Course item: list10){ System.out.println(item.getCourseName());}
		   
//test searchCoursesByCredit()
		   List <Course> list11 = courseDao.searchCoursesByCredit(new Long(4));
		   for(Course item: list11){ System.out.println(item.getCourseName());}
	       System.out.println("5----------------------------------------------------------------------");

	       
	       

	}

}
