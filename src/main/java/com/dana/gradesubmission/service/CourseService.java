package com.dana.gradesubmission.service;

import com.dana.gradesubmission.entity.Course;
import com.dana.gradesubmission.entity.Student;

import java.util.List;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
    Course addStudentToCourse(Long courseId, Long studentId);
    List<Student> getStudents(Long courseId);
}