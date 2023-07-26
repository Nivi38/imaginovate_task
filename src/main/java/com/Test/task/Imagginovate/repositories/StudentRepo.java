package com.Test.task.Imagginovate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Test.task.Imagginovate.entities.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
