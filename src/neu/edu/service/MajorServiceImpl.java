package neu.edu.service;

import java.util.List;

import neu.edu.dao.MajorDao;
import neu.edu.model.Major;

public class MajorServiceImpl implements MajorService {
	
	private MajorDao majorDao;
	
	public void setMajorDao(MajorDao majorDao)
	{this.majorDao = majorDao;}
	

	@Override
	public Major getMajorForStudent(String studentId) {
		
		return majorDao.getMajorForStudent(Long.valueOf(studentId));
	}

	@Override
	public List getMajors() {
		return majorDao.getMajors();
	}

}
