package com.example.UsingHibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.UsingHibernate.model.Student;
import com.example.UsingHibernate.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService stdService;
	
	@GetMapping("/getData")
	public List<Student> getData(@RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int pageSize)
	{
		List<Student> allDetails = stdService.getAllDetails();
		
		int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, allDetails.size());
        
		return allDetails.subList(startIndex, endIndex);
	}
	
	@PostMapping("/createData")
	public ResponseEntity<?> createStudentData(@RequestBody Student student)
	{
		 stdService.createStudent(student);
		return ResponseEntity.ok().body(student);
	}
	
	@GetMapping("/getData/{id}")
	public Student getStudentData(@PathVariable Integer id)
	{
		return stdService.getStudentById(id);
	}
	
	@PutMapping("/updateStudent/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Integer id, @RequestBody Student student) {
		
       stdService.updateStudent(id, student);
       return ResponseEntity.ok().body(student);
    }
	
	@DeleteMapping("/deleteById/{id}")
	public void deleteStudent(@PathVariable Integer id)
	{
		stdService.deleteStudentById(id);
	}

}
