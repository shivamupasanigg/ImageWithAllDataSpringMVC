package com.jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpa.Student;

@Service
@Transactional
public class StudentService {
	
	@Autowired
    private StudentRepository imageRepository;
	
	public void save(Student student) {
        imageRepository.save(student);	
    }
	
	public List<Student> getAllStudentData() {
        return imageRepository.findAll();
    }
	
	 public Student get(int id) {
	        return imageRepository.findById(id).get();
	    }
	
	public void modifyImage(int id,String name,String email,String address,String phone, byte[] image) {
    	imageRepository.updateImage(id,name,email,address,phone,image);
    }
	
	public void delete(int id) {
    	imageRepository.deleteById(id);
	 }

	public void updateProduct(int id,String name, String email, String address, String phone, byte[] bytes) {
		imageRepository.updateImage(id, name,email,address,phone, bytes);
		
	}

}
