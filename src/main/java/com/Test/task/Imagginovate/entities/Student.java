package com.Test.task.Imagginovate.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	//Id, First Name, Last Name, DOB, Section, Gender, Marks1, Marks 2, Marks 3, Total, Average, Result
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@NotNull(message = "first Name cannot be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	private String firstName;
	@NotNull(message = "last Name cannot be null")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
	private String lastName;
	@NotNull(message = "Date of Birth is mandatory")
	@Past(message = "Date of Birth should be in the past")
	private LocalDate dob;
	@Pattern(regexp = "[ABC]", message = "Section should be A, B, or C")
    private String section;

    @Pattern(regexp = "[MF]", message = "Gender should be M or F")
    private String gender;
	@Size(min=0,max=100)
	private int marks1;
	@Size(min=0,max=100)
	private int marks2;
	@Size(min=0,max=100)
	private int marks3;
	
	private long total;
	private double average;
	private String result;
	

}
