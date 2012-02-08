package neu.edu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import neu.edu.model.Course;
import neu.edu.model.Student;
import neu.edu.service.CourseService;
import neu.edu.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.context.SecurityContextHolder;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class CourseController {
	
	Util util;
	
	
	@Autowired
	private CourseService courseService;
	public void setCourseService (CourseService courseService)
	{this.courseService = courseService;}
	
	@Autowired
	private StudentService studentService;
	public void setStudentService (StudentService studentService)
	{this.studentService = studentService;}
	
	
	@RequestMapping("/studentCourses")
	public  ModelAndView showCoursesForStudent(Map<String, Object> map)
	{   		
		
		map.put("coursesForStudent", courseService.getCoursesForStudent(util.getId()));
        return new ModelAndView("studentCourses");
	}
	
	
	@RequestMapping("/instructorCourses")
	public  ModelAndView showCoursesForInstructor(Map<String, Object> map)
	{   		
		map.put("coursesForInstructor", courseService.getCoursesForInstructor(util.getId()));
		return new ModelAndView("instructorCourses");
	}
	
	
	@RequestMapping("/courses")
	public  ModelAndView addAndOfferCourse(Map<String, Object> map)
	{   	
		int remain;
		List selectedList = new ArrayList(); 
	
		for (int i=1; i<= courseService.lookUpCourses().size();i++)
		{
			selectedList.add(studentService.getStudentsNumForCourse(Integer.toString(i)));
		}
		map.put("courseList",courseService.lookUpCourses());
		map.put("selectedList", selectedList);
	    return new ModelAndView("addOfferCourses");
	}
	
	
	@RequestMapping("/createCourse")
	public ModelAndView createCourse(Model model)
	{
		model.addAttribute("course", new Course());
	    return new ModelAndView ("newCourse");
	}
	
	
	@RequestMapping(value = "saveCourse", method = RequestMethod.POST)
	public String saveCourse(Course course, BindingResult result) 
	{

		courseService.saveCourse(course);
        return "redirect:/courses.html";
	}
	
	
	@RequestMapping(value="addCourse/{courseId}")
	public @ResponseBody String addCourse(@PathVariable String courseId) {
		List<Course> courses=courseService.getCoursesForStudent(util.getId());
		System.out.println("the number of  courses in the list"+courses.size());
		for(int i=0;i<courses.size();i++){
			if(courses.get(i).getCourseId()==Integer.parseInt(courseId))
				return "course already registered before!";
		}
		courseService.addCourse(courseId, util.getId());
        return "course registered";
	}
	
	
	@RequestMapping(value="dropCourse/{courseId}")
	public String dropCourse(@PathVariable String courseId) {

		courseService.dropCourse(courseId, util.getId());
        return "redirect:/studentCourses.html";
	}
	
	
	@RequestMapping(value="offerCourse/{courseId}")
	public String offerCourse(@PathVariable String courseId) {

		courseService.offerCourse(courseId, util.getId());
        return "redirect:/courses.html";
	}
	
	@RequestMapping(value="deleteCourse/{courseId}")
	public String deleteCourse(@PathVariable String courseId) {

		
		courseService.deleteCourse(courseId, util.getId());
        return "redirect:/instructorCourses.html";
	}
	
	@RequestMapping(value="searchCourses")
	public String searchCourseByName(Map<String, Object> map,Course course)
	{
		
		List listByName = courseService.searchCoursesByName(course.getCourseName());
		map.put("course", new Course());
		map.put("coursesByName", listByName );
		
		return "searchCourses";
		
	}
	

}
