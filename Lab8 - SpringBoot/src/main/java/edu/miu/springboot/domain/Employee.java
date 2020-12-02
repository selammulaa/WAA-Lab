package edu.miu.springboot.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {
	private static final long serialVersionUID = -908L;

	private Long id;
	
	@NotEmpty
	@Size(min = 4, max = 50, message = "{employee.firstname}")
	private String firstName;
	
	@NotEmpty(message = "aaa")
	private String lastName;

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	private LocalDate birthDate;

	@NotNull
	private Integer salaryLevel;

	@Valid
	private Address address;


	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate
				+ ", salaryLevel=" + salaryLevel + ", address=" + address + "]";
	}

}
