package miu.edu.lab9.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee implements Serializable{

	@Serial
	private static final long serialVersionUID = 1L;

	@NotEmpty
	private String firstName;
	
	@NotEmpty
 	@Size(min=3, max=10, message="{Size.name.validation}")
	private String lastName;
	
	@NotEmpty
	private String email;



}
