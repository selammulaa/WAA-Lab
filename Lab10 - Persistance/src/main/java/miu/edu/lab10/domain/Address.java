package miu.edu.lab10.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="location")
@Getter
@Setter
public class Address {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 	private long id;

 	private String street;
	private String city;
	
 	private String state;

 	@Column(name="zip")
  	private String zipCode;

}
