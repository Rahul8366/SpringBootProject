package com.jsp.studentboot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.studentboot.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
