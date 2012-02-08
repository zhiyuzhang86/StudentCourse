package neu.edu.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import neu.edu.model.Major;
import neu.edu.model.Student;


public class StudentDaoImpl extends HibernateDaoSupport implements StudentDao {
	
	

	@SuppressWarnings("rawtypes")
	public List validateStudent(String email) {
		
     return getHibernateTemplate().find("from neu.edu.model.Student student left join fetch student.major courses where email=?",email );
	}
	
	

	public Student getStudent(Long studentId) {
		
		return (Student) getHibernateTemplate().find("from neu.edu.model.Student student left join fetch student.major courses where student.studentId=?",studentId.intValue()).get(0);
		 
	}

	public List getStudents() {
		
		return getHibernateTemplate().find("from neu.edu.model.Student student left join fetch student.major courses");
	}

	

	@Override
	public void saveStudent(Student student) {
		getHibernateTemplate().merge(student);
		
	}



	@Override
	public List getStudentsForCourse(Long courseId) {
		return 	getHibernateTemplate().find("select students from neu.edu.model.Course as course where course.courseId ="+courseId.intValue());
		
	}



	












	

}
