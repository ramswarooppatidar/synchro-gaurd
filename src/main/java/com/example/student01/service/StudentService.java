package com.example.student01.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.student01.exception.StudentAlreadyExistException;
import com.example.student01.exception.StudentNotFoundException;

import com.example.student01.entity.Student;
import com.example.student01.repository.StudentRepository;
import org.springframework.web.client.RestTemplate;
@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	private final RestTemplate restTemplate;
	
	public StudentService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	
	public String createStudent(Student student) {
		//find one by student name , 
		Optional<Student> optional = studentRepo.findByFirstName(student.getFirstName());

		if(optional.isPresent()) {
				throw new StudentAlreadyExistException("");			
		}
		studentRepo.save(student);
		return "create successfully";
		
	}
	
//	public ResponseEntity<Student> getStudentById(@PathVariable int id){
//		Student student = studentRepo.findById(id).orElseThrow(()-> new EmployeeNotFoundException());
//		System.out.println("student data is: "+student.getFirst_name()+" ,"+ student.getLast_name());
//		return new ResponseEntity<>(student, HttpStatus.OK);
//		}
	
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		try {
			Student student = studentRepo.findById(id).orElseThrow(()-> new StudentNotFoundException("employee not found by this id "));

		System.out.println("student data is: "+student.getFirstName()+" ,"+ student.getLastName());
		return new ResponseEntity<>(student, HttpStatus.OK);
		}catch(StudentNotFoundException e) {
			System.out.println("exceptions message is "+e.getMessage());
			throw new StudentNotFoundException(e.getMessage());
		}
		catch(Exception e) {
		throw new RuntimeException();
		}
		}
//	public ResponseEntity<Student> getStudentById(@PathVariable int id){
//		Student student = studentRepo.getById(id);
//		System.out.println("student :"+ student);
//		if(student == null) {
//		throw new EmployeeNotFoundException("employee not found by this id ");
//		}
//		try {
//		System.out.println("student data is: "+student.getFirst_name()+" ,"+ student.getLast_name());
//		return new ResponseEntity<>(student, HttpStatus.OK);
//		}catch(EmployeeNotFoundException e) {
//		throw new EmployeeNotFoundException("employee not found by this id ");
//		}catch(Exception e) {
//		throw new RuntimeException();
//		}
//		} 
	
		public ResponseEntity<List<Student>> getAll(){
			try {
				List<Student> list = studentRepo.findAll();
				return new ResponseEntity<>(list, HttpStatus.OK);
			}catch(Exception e) {
				throw new StudentNotFoundException("list not found");
			}		
		}
		public String callFakeApi() {
			String url = "https://jsonplaceholder.typicode.com/posts";
			String response = restTemplate.getForObject(url, String.class);
			System.out.println(response);
			return response;
		}
}
