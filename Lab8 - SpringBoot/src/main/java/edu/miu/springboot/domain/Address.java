package edu.miu.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

	@NotEmpty(message = "{address.street.validation}")
	private String street;
	private String city;

	@Size(min = 2, max = 2, message = "{address.state}")
	private String state;

	private String zipCode;

}
