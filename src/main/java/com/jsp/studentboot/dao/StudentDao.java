package com.jsp.studentboot.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.studentboot.Repo.StudentRepo;
import com.jsp.studentboot.dto.Student;

@Repository
public class StudentDao {

	@Autowired
	private StudentRepo studentRepo;
	
	public Student saveStudent(Student student) {
		return studentRepo.save(student);
	}
	
	public Optional<Student> findStudentById(int studId) {
		
		return studentRepo.findById(studId);
	}
	
	public Student deleteStudent(Student student) {
		studentRepo.delete(student);
		return student;
	}
	
}
