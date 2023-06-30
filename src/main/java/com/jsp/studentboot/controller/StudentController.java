package com.jsp.studentboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.studentboot.config.ResponceStructure;
import com.jsp.studentboot.dto.Student;
import com.jsp.studentboot.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<ResponceStructure<Student>> saveStudent(@Valid@RequestBody Student student) {
		return studentService.saveStudent(student);
	}
	
	@GetMapping
	public ResponseEntity<ResponceStructure<Student>> findStudent(@Valid@RequestParam int studId) {
		return studentService.findStudent(studId);
	}
	
	@PutMapping
	public ResponseEntity<ResponceStructure<Student>> updateStudent(@Valid@RequestBody Student student,int studId) {
		return studentService.updateStudent(student, studId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponceStructure<Student>> deleteStudent(@Valid@RequestParam int studId) {
		return studentService.deleteStudent(studId);
	}
}
