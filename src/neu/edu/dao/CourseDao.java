package neu.edu.dao;

import java.util.List;

import neu.edu.model.Course;

public interface CourseDao {
	
	public Course getCourse(Long courseId);
	public void saveCourse(Course course);
	public List getCourses();
	public List getCoursesForStudent(Long studentId);
	public List getCoursesForInstructor(Long instructorId);
	public List searchCoursesByName(String courseName);
	public List searchCoursesByCredit(Long credit);
	

}
