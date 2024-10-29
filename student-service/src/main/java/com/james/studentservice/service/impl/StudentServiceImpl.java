package com.james.studentservice.service.impl;

import com.james.studentservice.Presentation.dto.CreateStudentRequest;
import com.james.studentservice.Presentation.dto.StudentResponse;
import com.james.studentservice.helper.mapper.StudentMapper;
import com.james.studentservice.persistence.model.Student;
import com.james.studentservice.persistence.repository.StudentRepository;
import com.james.studentservice.service.feignClient.AddressFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentServiceImpl {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	WebClient webClient;

	@Autowired
	AddressFeignClient addressFeignClient;

	@Autowired
	CommonService commonService;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {
		Student student = Student.builder()
				.firstName(createStudentRequest.getFirstName())
				.lastName(createStudentRequest.getLastName())
				.email(createStudentRequest.getEmail())
				.addressId(createStudentRequest.getAddressId())
				.build();
		student = studentRepository.save(student);

		StudentResponse studentResponse = StudentMapper.mapModelToResponse(student);
		studentResponse.setAddressResponse(commonService.getAddressById(student.getAddressId()));
		//studentResponse.setAddressResponse(getAddressById(student.getAddressId()));
		return studentResponse;
	}

	public StudentResponse getById(long id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isEmpty())
			throw new NoSuchElementException("The studen with id " + id + " does not exist.");
		StudentResponse studentResponse = StudentMapper.mapModelToResponse(student.get());
		studentResponse.setAddressResponse(commonService.getAddressById(student.get().getAddressId()));
		//studentResponse.setAddressResponse(getAddressById(student.get().getAddressId()));
		return studentResponse;
	}


}