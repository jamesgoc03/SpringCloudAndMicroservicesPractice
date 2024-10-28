package com.james.studentservice.helper.mapper;

import com.james.studentservice.Presentation.dto.StudentResponse;
import com.james.studentservice.persistence.model.Student;

public class StudentMapper {

    public static StudentResponse mapModelToResponse(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .email(student.getEmail())
                .build();
    }

}
