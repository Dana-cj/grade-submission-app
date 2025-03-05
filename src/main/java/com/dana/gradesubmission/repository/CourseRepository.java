package com.dana.gradesubmission.repository;

import com.dana.gradesubmission.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {
}