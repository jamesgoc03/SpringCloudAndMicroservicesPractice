package com.james.universitymonolithicapplication.Presentation.controller;

import com.james.universitymonolithicapplication.Presentation.dto.CreateStudentRequest;
import com.james.universitymonolithicapplication.Presentation.dto.StudentResponse;
import com.james.universitymonolithicapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/create")
	public StudentResponse createStudent (@RequestBody CreateStudentRequest createStudentRequest) {
		return studentService.createStudent(createStudentRequest);
	}
	
	@GetMapping("getById/{id}")
	public StudentResponse getById (@PathVariable long id) {
		return studentService.getById(id);
	}
	
}