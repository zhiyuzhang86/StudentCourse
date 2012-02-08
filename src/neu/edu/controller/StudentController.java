package neu.edu.controller;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import neu.edu.model.Major;
import neu.edu.model.Student;
import neu.edu.service.MajorService;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class StudentController {
	

	Util util;
	
	@Autowired
	private StudentService studentService;
	public void setStudentService(StudentService studentService)
	{this.studentService = studentService;}
	

    
	@RequestMapping("/student.html")
	public  ModelAndView showStudent(Map<String, Object> map,
			HttpServletRequest request, HttpServletResponse response) throws IOException
	{   		
		byte[] photo=studentService.getStudent(util.getId()).getPhoto();

		
		String fileName=request.getSession().getServletContext().getRealPath("") + "/images/"+util.getId();
		System.out.println(fileName);
		OutputStream out = new FileOutputStream(fileName);
		out.write(photo);
		out.close();

		
//		MultipartFile file = studentService.getStudent(util.getId()).getPhoto();
//		fileName = request.getRealPath("") + "/images/"+ file.getOriginalFilename();
		map.put("student",studentService.getStudent(util.getId()));
		return new ModelAndView("student");
	}
	
	
	@RequestMapping("/updateStudent.html")
	public  ModelAndView updateStudent(Map<String, Object> map)
	{   		
		map.put("preStudent",studentService.getStudent(util.getId()));
		map.put("student", new Student());
		return new ModelAndView("updateStudent");
	}
	
	
	
	@RequestMapping(value = "update.html", method = RequestMethod.POST)
	public String saveStudent(@RequestParam String major,@ModelAttribute("student")Student student, BindingResult result) {

		
		studentService.updateStudent(student, major, util.getId());
		return "redirect:/student.html";
	}
	
	
	
	
	
	

}
