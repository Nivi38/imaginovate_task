package com.Test.task.Imagginovate.service;

import java.util.List;

import com.Test.task.Imagginovate.entities.Student;

public interface StudentServices {

	Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(long Id);
	void deleteById(long id);
	void UpdateStudent(long id,Student student);
}
