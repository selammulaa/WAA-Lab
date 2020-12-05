package miu.edu.security.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String firstName;
	private String lastName;
 	private int age;
	private String title;
 	private int employeeNumber;

	@OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name="addressid")
	private Address address;

 
}
