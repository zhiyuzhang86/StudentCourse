package neu.edu.dao;

import java.util.List;

import neu.edu.model.Instructor;
import neu.edu.model.Major;
import neu.edu.model.Student;

public interface StudentDao {
	
	public void saveStudent(Student student);
	public List validateStudent(String email);
	public Student getStudent(Long studentId);
	public List getStudents();
	public List getStudentsForCourse(Long courseId);
	



}
