package neu.edu.dao;

import java.util.List;

import neu.edu.model.Instructor;


public interface InstructorDao {
	
	public void saveInstructor(Instructor instructor);
	public Instructor getInstructor(Long instructorId);
	public List validateInstructor(String email);
	public List getInstructors();
	public Instructor getInstructorForCourse(Long courseId);

}
