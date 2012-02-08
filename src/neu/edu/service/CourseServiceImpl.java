package neu.edu.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.catalina.User;

import neu.edu.dao.CourseDao;
import neu.edu.dao.InstructorDao;
import neu.edu.dao.MajorDao;
import neu.edu.dao.StudentDao;
import neu.edu.model.Course;
import neu.edu.model.Instructor;
import neu.edu.model.Student;

public class CourseServiceImpl implements CourseService {

	private StudentDao studentDao;
	private CourseDao courseDao;
	private InstructorDao instructorDao;
	
	
	public void setStudentDao(StudentDao studentDao)
	{this.studentDao = studentDao;}
	public void setCourseDao(CourseDao courseDao)
	{this.courseDao = courseDao;}
	public void setInstructorDao(InstructorDao instructorDao)
	{this.instructorDao = instructorDao;}
	
	
	
	@Override
	public List lookUpCourses() {
		
		return courseDao.getCourses();
	}

	@Override
	public List getCoursesForStudent(String studentId) {
		
		return courseDao.getCoursesForStudent(Long.valueOf(studentId));
	}

	@Override
	public void addCourse(String courseId, String studentId) {
		
		Student student = studentDao.getStudent(Long.valueOf(studentId));
		Course course = courseDao.getCourse(Long.valueOf(courseId));
		Set newCourseListForStudent = student.getCourses();
		Set newStudentListForCourse = course.getStudents();
		newStudentListForCourse.add(student);
		newCourseListForStudent.add(course);
		student.setCourses(newCourseListForStudent);
		course.setStudents(newStudentListForCourse);
		studentDao.saveStudent(student);
		courseDao.saveCourse(course);
		
		
	}

	@Override
	public List getCoursesForInstructor(String instructorId) {
		
		return courseDao.getCoursesForInstructor(Long.valueOf(instructorId));
	}

	@Override
	public void offerCourse(String courseId, String instructorId) {
//		System.out.println("enter serive layer");

		Instructor instructor = instructorDao.getInstructor(Long.valueOf(instructorId));
		Course course = courseDao.getCourse(Long.valueOf(courseId));
		Set newCourseList = instructor.getCourses();
		newCourseList.add(course);
		instructor.setCourses(newCourseList);
		instructorDao.saveInstructor(instructor);
		course.setInstructor(instructor);
		courseDao.saveCourse(course);
//   	System.out.println("leave serive layer");
		
		
	}
	@Override
	public void saveCourse(Course course) {
		courseDao.saveCourse(course);
		
	}

	@Override
	public void dropCourse(String courseId, String studentId) {
		
		Student student = studentDao.getStudent(Long.valueOf(studentId));
		Course course = courseDao.getCourse(Long.valueOf(courseId));
//		System.out.println("the id of the course to be removed:"+course.getCourseId());
		Set<Course> courseListForStudent = student.getCourses();
		Set<Course>  newCourseListForStudent=new HashSet<Course>();
		Iterator iterator1=courseListForStudent.iterator();
		while(iterator1.hasNext()){
			Course Icourse=(Course) iterator1.next();
			if(Icourse.getCourseId()!=Integer.parseInt(courseId)){
				newCourseListForStudent.add(Icourse);
			}
		}
		student.setCourses(newCourseListForStudent);
		studentDao.saveStudent(student);
		
		Set<Student> studentListForCourse = course.getStudents();
		Set<Student> newStudentListForCourse= new HashSet<Student>();
		Iterator iterator2 = studentListForCourse.iterator();
		while(iterator2.hasNext()){
			Student Istudent=(Student)iterator2.next();
			if(Istudent.getStudentId()!=Integer.parseInt(studentId))
			{newStudentListForCourse.add(Istudent);
			}
		}
		course.setStudents(newStudentListForCourse);
		courseDao.saveCourse(course);
		
		
/*		newCourseListForStudent.remove(course);
*///		System.out.println("new:"+newCourseListForStudent.size());

		
		
	}
	@Override
	public void deleteCourse(String courseId, String instructorId) {


		Instructor instructor = instructorDao.getInstructor(Long.valueOf(instructorId));
		Course course = courseDao.getCourse(Long.valueOf(courseId));
		Set<Course> courseListForInstructor = instructor.getCourses();
		Set<Course>  newCourseListForInstructor=new HashSet<Course>();
		Iterator iterator = courseListForInstructor.iterator();
		while(iterator.hasNext()){
			Course Icourse=(Course) iterator.next();
			if(Icourse.getCourseId()!=Integer.parseInt(courseId)){
				newCourseListForInstructor.add(Icourse);
			}
		}
		instructor.setCourses(newCourseListForInstructor);
		instructorDao.saveInstructor(instructor);
		
		course.setInstructor(null);
		courseDao.saveCourse(course);
		
		
		
	}
	@Override
	public List searchCoursesByName(String courseName) {
		// TODO Auto-generated method stub
		return courseDao.searchCoursesByName(courseName);
	}
	@Override
	public List searchCoursesByCredit(int credit) {
		
		return courseDao.searchCoursesByCredit(Long.valueOf(credit));
	}

}
