package com.jsp.studentboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.studentboot.config.ResponceStructure;
import com.jsp.studentboot.dao.StudentDao;
import com.jsp.studentboot.dto.Student;
import com.jsp.studentboot.exception.StudentNotFoundByIdException;

@Service
public class StudentService {

   @Autowired
   private StudentDao studentDao;
   
   public ResponseEntity<ResponceStructure<Student>> saveStudent(Student student) {
	   student = studentDao.saveStudent(student);
	   
	   ResponceStructure<Student> responceStructure=new ResponceStructure<Student>();
	   responceStructure.setStatus(HttpStatus.CREATED.value());
	   responceStructure.setMessage("student added sucefully");
	   responceStructure.setData(student);
	   return new ResponseEntity<ResponceStructure<Student>>(responceStructure, HttpStatus.CREATED); 
   }
   
   public ResponseEntity<ResponceStructure<Student>> findStudent(int studId){
	   Optional<Student> optional =studentDao.findStudentById(studId);
	   if(optional.isEmpty()) {
		   throw new StudentNotFoundByIdException("Failed to find the student!");
	   }
	   else {
		   Student student= optional.get();
		   
		   ResponceStructure<Student> responceStructure=new ResponceStructure<>();
		   responceStructure.setStatus(HttpStatus.FOUND.value());
		   responceStructure.setMessage("StudentFound!!");
		   responceStructure.setData(student);
		   return new ResponseEntity<ResponceStructure<Student>>(responceStructure,HttpStatus.FOUND);
	   }
   }
   
   public ResponseEntity<ResponceStructure<Student>> updateStudent(Student student,int studId) {
	   Optional<Student> optional =studentDao.findStudentById(studId);
	   if(optional.isEmpty()) {
		   throw new StudentNotFoundByIdException("Failed to find the student!");
	   }
	   else {
		   student.setStudId(studId);
		   student=studentDao.saveStudent(student);
		   
		   ResponceStructure<Student> responceStructure=new ResponceStructure<Student>();
		   responceStructure.setStatus(HttpStatus.OK.value());
		   responceStructure.setMessage("student updated succefully");
		   responceStructure.setData(student);
		   
		   return new ResponseEntity<ResponceStructure<Student>>(responceStructure,HttpStatus.FOUND);
	   }
   }
   
   public ResponseEntity<ResponceStructure<Student>> deleteStudent(int studId) {
	   Optional<Student> optional= studentDao.findStudentById(studId);
	   if(optional.isEmpty()) {
		  throw new StudentNotFoundByIdException("Failed to find the student!");
	   }
	   else {
		   Student student=optional.get();
		   student= studentDao.deleteStudent(student);
		   ResponceStructure<Student> responceStructure=new ResponceStructure<Student>();
		   responceStructure.setStatus(HttpStatus.OK.value());
		   responceStructure.setMessage("student Deleted succefully");
		   responceStructure.setData(student);
		   
		   return new ResponseEntity<ResponceStructure<Student>>(responceStructure,HttpStatus.FOUND);
	   }
   }
   
}
