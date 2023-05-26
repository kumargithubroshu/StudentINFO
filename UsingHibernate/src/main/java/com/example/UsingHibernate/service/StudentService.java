package com.example.UsingHibernate.service;

import java.util.List;

import com.example.UsingHibernate.model.Student;

public interface StudentService {
	
	public List<Student> getAllDetails();
	
	public void createStudent(Student student);
	
	public Student getStudentById(Integer id);
	
	public void updateStudent(Integer id,Student student );
	
	public void deleteStudentById(Integer id);

}
