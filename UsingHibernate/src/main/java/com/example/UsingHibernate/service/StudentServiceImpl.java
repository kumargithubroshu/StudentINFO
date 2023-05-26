package com.example.UsingHibernate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UsingHibernate.model.Student;
import com.example.UsingHibernate.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepo stdRepo;

	@Override
	public List<Student> getAllDetails() {
		return stdRepo.findAll();
	}

	@Override
	public void createStudent(Student student) {
		stdRepo.save(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> findById = stdRepo.findById(id);
		if(findById.isPresent())
		{
			Student student = findById.get();
			return student;
		}
		return null;
	}

	@Override
	public void updateStudent(Integer id, Student student) {
		Optional<Student> byId = stdRepo.findById(id);
		if(byId.isPresent())
		{
			Student student2=byId.get();
			student2.setName(student.getName());
			student2.setSubject(student.getSubject());
			student2.setMarks(student.getMarks());
			student2.setCity(student.getCity());
			 stdRepo.save(student2);
		}
	}

	@Override
	public void deleteStudentById(Integer id) {
		stdRepo.deleteById(id);
	}

}
