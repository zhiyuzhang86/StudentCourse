package neu.edu.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import neu.edu.model.Course;
import neu.edu.model.Instructor;

public class InstructorDaoImpl extends HibernateDaoSupport implements InstructorDao {

	@Override
	public Instructor getInstructor(Long instructorId) {
		
		return (Instructor)getHibernateTemplate().find("from neu.edu.model.Instructor instructor left join fetch instructor.courses where instructor.instructorId=?",instructorId.intValue()).get(0);
	}

	@Override
	public List validateInstructor(String email) {
		
		return getHibernateTemplate().find("from neu.edu.model.Instructor instructor where email=?", email );
	}

	@Override
	public List getInstructors() {
		
		return getHibernateTemplate().find("from neu.edu.model.Instructor instructor ");
	}

	@Override
	public Instructor getInstructorForCourse(Long courseId) {
		List list = getHibernateTemplate().find("select instructor from neu.edu.model.Course as course where course.courseId ="+courseId.intValue());
		
		if(list.size()==0){System.out.println("Dao not found");return null;}
		else {return (Instructor) getHibernateTemplate().find("select instructor from neu.edu.model.Course as course where course.courseId ="+courseId.intValue()).get(0);
		}
	}

	@Override
	public void saveInstructor(Instructor instructor) {
		getHibernateTemplate().merge(instructor);
		
	}

	

	
}
