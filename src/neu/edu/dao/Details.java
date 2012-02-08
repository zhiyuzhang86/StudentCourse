package neu.edu.dao;

import java.util.List;

import neu.edu.dao.StudentDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.GrantedAuthority;
import org.springframework.security.GrantedAuthorityImpl;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;

public class Details implements UserDetailsService {

	@Autowired
	private StudentDao studentDao;
	public void setStudentDao(StudentDao studentDao)
	{this.studentDao = studentDao;}
	@Autowired
	private InstructorDao instructorDao;
	public void setInstructorDao(InstructorDao instructorDao)
	{this.instructorDao = instructorDao;}
	
	
	
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException, DataAccessException {
		List students = studentDao.validateStudent(userName);
		List instructors = instructorDao.validateInstructor(userName);
		if((students.size() ==0)&&(instructors.size()==0)) throw new UsernameNotFoundException(userName);
		
		else if ((students.size() !=0)&&(instructors.size()==0))
		{
		neu.edu.model.Student student = (neu.edu.model.Student) students.get(0);
		
		GrantedAuthority authority=new GrantedAuthorityImpl("ROLE_STUDENT");
		return new org.springframework.security.userdetails.User(String.valueOf(student.getStudentId()), student.getPassword(), 
				true, true, true, true, new GrantedAuthority[] {authority});
		}
		else 
		{
			neu.edu.model.Instructor instructor = (neu.edu.model.Instructor) instructors.get(0);
			GrantedAuthority authority=new GrantedAuthorityImpl("ROLE_INSTRUCTOR");
			return new org.springframework.security.userdetails.User(String.valueOf(instructor.getInstructorId()), instructor.getPassword(), 
					true, true, true, true, new GrantedAuthority[] {authority});
			}
	}

}
