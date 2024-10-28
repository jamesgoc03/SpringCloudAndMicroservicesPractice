package com.james.universitymonolithicapplication.service;

import com.james.universitymonolithicapplication.Presentation.dto.CreateStudentRequest;
import com.james.universitymonolithicapplication.Presentation.dto.StudentResponse;
import com.james.universitymonolithicapplication.helper.mapper.StudentMapper;
import com.james.universitymonolithicapplication.persistence.model.Address;
import com.james.universitymonolithicapplication.persistence.model.Student;
import com.james.universitymonolithicapplication.persistence.repository.AddressRepository;
import com.james.universitymonolithicapplication.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private AddressRepository addressRepository;

	public StudentResponse createStudent(CreateStudentRequest createStudentRequest) {

		Address address = Address.builder()
				.street(createStudentRequest.getStreet())
				.city(createStudentRequest.getCity())
				.build();
		address = addressRepository.save(address);

		Student student = Student.builder()
				.firstName(createStudentRequest.getFirstName())
				.lastName(createStudentRequest.getLastName())
				.email(createStudentRequest.getEmail())
				.address(address)
				.build();
		student = studentRepository.save(student);

		return StudentMapper.mapModelToResponse(student);
	}

	public StudentResponse getById(long id) {
		Optional<Student> student = studentRepository.findById(id);
		if(student.isEmpty())
			throw new NoSuchElementException("The studen with id " + id + " does not exist.");
		return StudentMapper.mapModelToResponse(student.get());
	}

}