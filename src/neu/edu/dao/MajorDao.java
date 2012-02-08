package neu.edu.dao;

import java.util.List;

import neu.edu.model.Major;

public interface MajorDao {
	
	
	public Major getMajor(Long majorId);
	public List getMajors();
	public Major getMajorForStudent(Long studentId);

}
