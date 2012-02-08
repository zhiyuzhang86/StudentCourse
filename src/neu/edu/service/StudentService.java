package neu.edu.service;

import java.util.List;

import neu.edu.model.Major;
import neu.edu.model.Student;

public interface StudentService {
	
	public void saveStudent(Student student, String majorId);
	public void updateStudent(Student student, String majorId ,String studentId);
	public Student getStudent(String studentId);
	public List getStudents();
	public int getStudentsNumForCourse(String courseId);
	
	
	
	

}
