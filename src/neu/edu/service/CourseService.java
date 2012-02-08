package neu.edu.service;

import java.util.List;

import neu.edu.model.Course;

public interface CourseService {
	
	public List lookUpCourses();
	public void saveCourse(Course course);
	public List getCoursesForStudent(String studentId);
	public void addCourse(String courseId, String studentId);
	public void dropCourse(String courseId, String studentId);
	public List getCoursesForInstructor(String instructorId);
	public void offerCourse(String courseId, String instructorId);
	public void deleteCourse(String courseId, String instructorId);
	public List searchCoursesByName(String courseName);
	public List searchCoursesByCredit(int credit); 

}
