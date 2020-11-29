
package com.students.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


public class Phone implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@Range(min = 100, max = 999, message = "{error.areacode}")
 	private Integer area;

	@NotNull
	@Min(value = 100, message = "{error.prefix}")
	@Max(value = 999, message = "{error.prefix}")
 	private Integer prefix;

	@NotNull
	@Min(value = 1000, message = "{error.number}")
	@Max(value = 9999, message = "{error.number}")
 	private Integer number;
	

 
	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

 	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}
}
