package neu.edu.service;

import java.util.List;

import neu.edu.model.Instructor;

public interface InstructorService {
	
	public Instructor getInstructor(String instructorId);
	public List getInstructors();
	public Instructor getInstructorForCourse(String courseId);
	public void saveInstructor(Instructor instructor);
	

}
