package com.dana.gradesubmission.repository;

import com.dana.gradesubmission.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
}