package com.james.universitymonolithicapplication.Presentation.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String city;

}
