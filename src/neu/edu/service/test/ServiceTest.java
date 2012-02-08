package neu.edu.service.test;

import java.util.List;

import neu.edu.dao.MajorDao;
import neu.edu.model.Course;
import neu.edu.model.Instructor;
import neu.edu.model.Major;
import neu.edu.model.Student;
import neu.edu.service.CourseService;
import neu.edu.service.InstructorService;
import neu.edu.service.MajorService;
import neu.edu.service.StudentService;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class ServiceTest {

	/**
	 * @param args
	 * @return 
	 */
	
	 
	 
	 
	public static void main(String[] args) {
		
		 Resource res = new ClassPathResource("service-beans.xml");
		 BeanFactory factory = new XmlBeanFactory(res);
		 MajorService majorService = (MajorService) factory.getBean("myMajorService");
		 StudentService studentService = (StudentService) factory.getBean("myStudentService");
		 CourseService courseService = (CourseService) factory.getBean("myCourseService");
		 InstructorService instructorService = (InstructorService) factory.getBean("myInstructorService");
		 



		 
		 
		/* Major major = new Major("Electrical Engineering","Paul");*/
		 Student student = new Student("freddy", "zhang@gmail.com", "666", "M", "1986/02/22", null, "hello", null, null);
		
		   
		//test getMajorForStudnet()
		 
		System.out.println(majorService.getMajorForStudent("1").getMajorName());
		
		//test getMajors()
		
		 List<Major> list1= majorService.getMajors();
		 for(Major item : list1)
		 {System.out.println(item.getMajorName());}
		 System.out.println();
		 
		 System.out.println("1----------------------------------------------------------------------");
		 
		 //test getStudent()
		 
		 System.out.println(studentService.getStudent("1").getStudentName());
		 
		 // test saveStudent()
		
		
		
    	//	 studentService.saveStudent(student, "1");
		 
		   System.out.println(studentService.getStudentsNumForCourse("2"));
		 
		 System.out.println("2----------------------------------------------------------------------");
		
		 // test getInstructor()
		 
		 System.out.println(instructorService.getInstructor("1").getInstructorName());
		 
		 // test getInstructorForCourse()
		 Instructor instructor=instructorService.getInstructorForCourse("2");
		 System.out.println("fails");
		 if (instructor==null)
		 {
			 System.out.println("Service not found!");
			 }
		 else{ 
			 System.out.println(instructorService.getInstructorForCourse("2").getInstructorName());
			 }
		 
		 

		 System.out.println("3----------------------------------------------------------------------");
		 
		 // test lookUpCourses()
		 
		 List<Course> list2= courseService.lookUpCourses();
		 for(Course item : list2)
		 {System.out.println(item.getCourseName());}
		 System.out.println();
		 
		 // test getCoursesForStudent()
		 
		 List<Course> list3= courseService.getCoursesForStudent("2");
		 for(Course item : list3)
		 {System.out.println(item.getCourseName());}
		 System.out.println();
		 
		 // test getCoursesForInstructor()
		 
		 List<Course> list4= courseService.getCoursesForInstructor("3");
		 for(Course item : list4)
		 {System.out.println(item.getCourseName());}
		 System.out.println();
	      System.out.println("4----------------------------------------------------------------------");

		 //test addCourse()
		 
	//	 courseService.addCourse("2", "3");
		 
		 //test dropCourse()
	//	 courseService.dropCourse("1","3"); 
		 
		 
		 //test offerCourse()
		 
	//	 courseService.offerCourse("1", "2");
		 //test deleteCourse()
		 
		// courseService.deleteCourse("1", "2");
		 
		 // test updateStudent()
	//	  studentService.updateStudent(student, "2", "1");
	       System.out.println("5----------------------------------------------------------------------");

	     //test searchCourseByName()
	       List <Course> list10 = courseService.searchCoursesByName("it");
		   for(Course item: list10){ System.out.println(item.getCourseName());}
		   System.out.println();
		   
//test searchCoursesByCredit()
		   List <Course> list11 = courseService.searchCoursesByCredit(4);
		   for(Course item: list11){ System.out.println(item.getCourseName());}
		 
		 
		 
		 
	}

}
