package neu.edu.service;

import java.util.List;
import java.util.Set;

import neu.edu.dao.CourseDao;
import neu.edu.dao.MajorDao;
import neu.edu.dao.StudentDao;
import neu.edu.model.Course;
import neu.edu.model.Major;
import neu.edu.model.Student;

public class StudentServiceImpl implements StudentService {
	
	private StudentDao studentDao;
	private MajorDao majorDao;
	private CourseDao courseDao;
	public void setStudentDao(StudentDao studentDao)
	{this.studentDao = studentDao;}
	public void setMajorDao(MajorDao majorDao)
	{this.majorDao = majorDao;}
	public void setCourseDao(CourseDao courseDao)
	{this.courseDao = courseDao;}

	@Override
	public void saveStudent(Student student, String majorId) {

		Major major = majorDao.getMajor(Long.valueOf(majorId));
		student.setMajor(major);
		studentDao.saveStudent(student);
		
	}

	@Override
	public Student getStudent(String studentId) {

		return studentDao.getStudent(Long.valueOf(studentId));
	}
	@Override
	public List getStudents() {
		
		return studentDao.getStudents();
	}
	@Override
	public void updateStudent(Student student, String majorId, String studentId) {
		Student preStudent = studentDao.getStudent(Long.valueOf(studentId));
		Major major = majorDao.getMajor(Long.valueOf(majorId));
		student.setMajor(major);
		student.setStudentId(Integer.valueOf(studentId));
		student.setCourses(preStudent.getCourses());
		student.setPhoto(preStudent.getPhoto());
		
		studentDao.saveStudent(student);
		
	}
	@Override
	public int getStudentsNumForCourse(String courseId) {
		
		return studentDao.getStudentsForCourse(Long.valueOf(courseId)).size();
	}
	
	

}
