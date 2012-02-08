package neu.edu.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import neu.edu.model.Course;

public class CourseDaoImpl extends HibernateDaoSupport implements CourseDao {

	@Override
	public Course getCourse(Long courseId) {
		
	//	return (Course)getHibernateTemplate().load(Course.class, courseId.intValue());
		
	return (Course)getHibernateTemplate().find("from neu.edu.model.Course course left join fetch course.instructor students where course.courseId=?",courseId.intValue()).get(0);
	}

	@Override
	public List getCourses() {
		
		return getHibernateTemplate().find("from neu.edu.model.Course course left join fetch course.instructor students");
	}

	@Override
	public List getCoursesForStudent(Long studentId) {
		
		return getHibernateTemplate().find("select courses from neu.edu.model.Student as student  where student.studentId ="+studentId.intValue());
	}

	@Override
	public List getCoursesForInstructor(Long instructorId) {
		return getHibernateTemplate().find("select courses from neu.edu.model.Instructor as instructor where instructor.instructorId ="+instructorId.intValue());
		

	}

	@Override
	public void saveCourse(Course course) {
		getHibernateTemplate().merge(course);
		
	}

	@Override
	public List searchCoursesByName(String courseName) {
		// TODO Auto-generated method stub
	//	String query = "from user u where u.name like :name"
			String query = "from neu.edu.model.Course course left join fetch course.instructor students where course.courseName like:name";
			
			return getHibernateTemplate().findByNamedParam(query, "name", '%' + courseName + '%');	}

	@Override
	public List searchCoursesByCredit(Long credit) {
		if(credit==null)
		{credit=new Long(0);}
		List list = getHibernateTemplate().find("from neu.edu.model.Course course left join fetch course.instructor students where course.credit=?",credit.intValue());
	
		return list;
		
	}

}
