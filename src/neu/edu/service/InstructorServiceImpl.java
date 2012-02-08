package neu.edu.service;

import java.util.List;

import neu.edu.dao.InstructorDao;
import neu.edu.model.Instructor;

public class InstructorServiceImpl implements InstructorService {

	private InstructorDao instructorDao;
	public void setInstructorDao(InstructorDao instructorDao)
	{this.instructorDao = instructorDao;}
	
	@Override
	public Instructor getInstructor(String instructorId) {
		
		return instructorDao.getInstructor(Long.valueOf(instructorId));
	}

	@Override
	public Instructor getInstructorForCourse(String courseId) {
		
		return instructorDao.getInstructorForCourse(Long.valueOf(courseId));
	}

	@Override
	public void saveInstructor(Instructor instructor) {
		instructorDao.saveInstructor(instructor);
		
	}

	@Override
	public List getInstructors() {
		
		return  instructorDao.getInstructors();
	}

}
