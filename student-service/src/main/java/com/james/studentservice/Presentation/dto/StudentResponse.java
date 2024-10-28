package com.james.studentservice.Presentation.dto;

import com.james.studentservice.service.http.AddressResponse;
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
	private AddressResponse addressResponse;

}
