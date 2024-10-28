package com.james.universitymonolithicapplication.helper.mapper;

import com.james.universitymonolithicapplication.Presentation.dto.StudentResponse;
import com.james.universitymonolithicapplication.persistence.model.Student;

public class StudentMapper {

    public static StudentResponse mapModelToResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .street(student.getAddress().getStreet())
                .city(student.getAddress().getCity())
                .build();
    }

}
