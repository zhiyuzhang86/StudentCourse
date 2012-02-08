package neu.edu.controller;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;



import neu.edu.model.Instructor;
import neu.edu.model.Major;
import neu.edu.model.Student;
import neu.edu.service.InstructorService;
import neu.edu.service.MajorService;
import neu.edu.service.StudentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
	
	@Autowired
	private StudentService studentService;
	public void setStudentService(StudentService studentService)
	{this.studentService = studentService;}
	@Autowired
	private InstructorService instructorService;
	public void setInstructorService(InstructorService instructorService)
	{this.instructorService = instructorService;}
	
	

	@RequestMapping("/studentRegister")
	public  ModelAndView addStudent(Model model)
	{   		
		model.addAttribute("student", new Student());
		return new ModelAndView("studentRegister");
 
	}
	
	@RequestMapping(value = "/saveStudent.html", method = RequestMethod.POST)
	public String saveStudent(@RequestParam("major") String major,@RequestParam("file") MultipartFile file,@ModelAttribute("student")Student student, BindingResult result) throws IOException {

		System.out.println("here");
		student.setPhoto(file.getBytes());
		studentService.saveStudent(student, major);
        return "redirect:/login.jsp";
		
	}
	
	@RequestMapping("/instructorRegister")
	public ModelAndView addInstructor(Model model)
	{
		model.addAttribute("instructor", new Instructor());
		return new ModelAndView("instructorRegister");
	}
	
	@RequestMapping(value = "saveInstructor.html", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute("instructor")Instructor instructor, BindingResult result) {


		instructorService.saveInstructor(instructor);
        return "redirect:/login.jsp";
	}
	
	
	

}
