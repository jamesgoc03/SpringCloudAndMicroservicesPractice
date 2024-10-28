package com.james.studentservice.Presentation.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudentRequest {

	private String firstName;
	private String lastName;
	private String email;
	private Long addressId;

}
