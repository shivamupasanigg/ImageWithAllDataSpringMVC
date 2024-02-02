package com.jpa.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jpa.Student;
import com.jpa.dao.StudentService;

@Controller
public class Studentcontroller {
	
	@Autowired
    private StudentService studentService;

	@GetMapping("/index")
	public String view(Model m) {
		m.addAttribute("student", new Student());
		return "index";

	}

	@PostMapping("/insert")
	public String uploadImage(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("address") String address,@RequestParam("phone") String phone,@RequestParam("file") MultipartFile file) throws IOException {
		
		Student student = new Student();
		
		student.setName(name);
		student.setEmail(email);
		student.setAddress(address);
		student.setPhone(phone);
		
		student.setImage(file.getBytes());
		
		studentService.save(student);
		
		return "index";
	}
	
	@GetMapping("/showImage")
    public String displayAllImages(Model model) {
    		List<Student> studentList = studentService.getAllStudentData();
    		
    		List<String> base64Images = new ArrayList<>();
    		String base64Image;
    		for (Student student : studentList) {
    	        if (student.getImage() != null) {
    	            base64Image = Base64.getEncoder().encodeToString(student.getImage());
    	            base64Images.add(base64Image);
    	        }
    	    }
    		model.addAttribute("studentList",studentList);
    	    model.addAttribute("base64Images", base64Images);
    	    return "imageListPage";
	}
	
	
	@GetMapping("/Edit")
	public String editCustomerForm(@RequestParam int id,Model mv) {
	    //ModelAndView mav = new ModelAndView("Edit");
		Student student =studentService.get(id);
	    mv.addAttribute("student", student);
	   // mv.setViewName("Edit");
	    return "Edit";
	}
	
	@PostMapping("/update")
	public ModelAndView updateProduct(@RequestParam("id") int id,@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("address") String address,@RequestParam("phone") String phone,@RequestParam("file") MultipartFile file,ModelAndView mv) throws IOException {
		studentService.updateProduct(id,name,email,address,phone,file.getBytes());
        mv.addObject("updateMsg","data updated sucessfully");
	    mv.setViewName("update");
        return mv;
    }
	
	
	
	
	@GetMapping("/Delete")
	public ModelAndView deleteUserForm(@RequestParam int id,ModelAndView mv) {
		studentService.delete(id);
	    mv.addObject("deleteMsg","data deleted sucessfully");
	    mv.setViewName("Delete");
		return mv;    
	}
	
	
	
	
	
	
}
