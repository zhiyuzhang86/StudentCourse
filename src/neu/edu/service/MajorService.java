package neu.edu.service;

import java.util.List;

import neu.edu.model.Major;

public interface MajorService {
	
	public Major getMajorForStudent(String studentId);
	public List getMajors();

}
