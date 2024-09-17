package com.example.student01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student01.entity.Student;
import com.example.student01.service.*;

@RequestMapping
@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("student/create")
	public String createStudent(@RequestBody Student student) {
		studentService.createStudent(student);
		return "create successfully";
	}
	
	@GetMapping("student/{id}")
	public ResponseEntity<Student> getById(@PathVariable int id){
		ResponseEntity<Student> student = studentService.getStudentById(id);
//		System.out.println("student data is: "+student.getFirstName());
		System.out.println("student :"+student);
		return new ResponseEntity<>(student.getBody(), HttpStatus.OK);
	}
	
	@GetMapping("student/getAll")
	public ResponseEntity<List<Student>> getAll(){
		ResponseEntity<List<Student>> listOfStudEntity = studentService.getAll();
		return new ResponseEntity<>(listOfStudEntity.getBody(), HttpStatus.OK);
	}
	
	@GetMapping("student/callFakeApi")
	public String callFakeApi() {
		String reString = studentService.callFakeApi();
		return reString;
	}
	
	
}
