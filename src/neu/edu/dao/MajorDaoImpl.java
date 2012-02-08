package neu.edu.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import neu.edu.model.Major;
import neu.edu.model.Student;

public class  MajorDaoImpl extends HibernateDaoSupport implements MajorDao{

	

	@Override
	public Major getMajor(Long majorId) {
		
		return (Major)getHibernateTemplate().get(Major.class, majorId.intValue());
	}

	@Override
	public List getMajors() {
		
		return getHibernateTemplate().find("from neu.edu.model.Major");
	}

	@Override
	public Major getMajorForStudent(Long studentId) {
		
		return (Major) getHibernateTemplate().load(Student.class, studentId.intValue()).getMajor();
	}
	
	

}
