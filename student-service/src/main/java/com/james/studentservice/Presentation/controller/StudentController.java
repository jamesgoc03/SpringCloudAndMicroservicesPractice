package com.james.studentservice.Presentation.controller;

import com.james.studentservice.Presentation.dto.CreateStudentRequest;
import com.james.studentservice.Presentation.dto.StudentResponse;
import com.james.studentservice.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentServiceImpl studentServiceImpl;
	
	@PostMapping("/create")
	public StudentResponse createStudent (@RequestBody CreateStudentRequest createStudentRequest) {
		return studentServiceImpl.createStudent(createStudentRequest);
	}
	
	@GetMapping("getById/{id}")
	public StudentResponse getById (@PathVariable long id) {
		return studentServiceImpl.getById(id);
	}
	
}