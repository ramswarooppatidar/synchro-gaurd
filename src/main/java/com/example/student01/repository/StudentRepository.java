package com.example.student01.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.student01.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Optional<Student> findByFirstName(String firsName);
	
	
}
