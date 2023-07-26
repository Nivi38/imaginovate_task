package com.Test.task.Imagginovate.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Test.task.Imagginovate.entities.Student;
import com.Test.task.Imagginovate.repositories.StudentRepo;
import com.Test.task.Imagginovate.service.StudentServices;

@Service
public class StudentServiceImpl implements StudentServices {
	@Autowired
	private StudentRepo studentRepo;

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		 calculateAndUpdateResult(student);
		Student st=studentRepo.save(student);
		
		return st;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(long id) {
		// TODO Auto-generated method stub
		
		return studentRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		studentRepo.deleteById(id);
		return;
		
	}

	@Override
	public void UpdateStudent(long id, Student student) {
		// TODO Auto-generated method stub
		 Student student1 = studentRepo.findById(id).orElse(null);
	        if (student != null) {
	            student1.setFirstName(student.getFirstName());
	            student1.setLastName(student.getLastName());
	            student1.setDob(student.getDob());
	            student1.setMarks1(student.getMarks1());
	            student1.setMarks2(student.getMarks2());
	            student1.setMarks3(student.getMarks3());
	            student1.setSection(student.getSection());
	            student1.setGender(student.getGender());
	        }
	        return;

	}
	private void calculateAndUpdateResult(Student student) {
        // Your calculation logic remains the same as before
        long totalMarks = student.getMarks1() + student.getMarks2() + student.getMarks3();
        double averageMarks = totalMarks / 3.0;
        String result = (student.getMarks1() >= 35 && student.getMarks2() >= 35 && student.getMarks3() >= 35) ? "Pass" : "Fail";

        student.setTotal(totalMarks);
        student.setAverage(averageMarks);
        student.setResult(result);
    }
}
