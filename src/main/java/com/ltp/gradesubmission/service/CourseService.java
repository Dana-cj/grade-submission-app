package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;

import java.util.List;

public interface CourseService {
    Course getCourse(Long id);
    Course saveCourse(Course course);
    void deleteCourse(Long id);
    List<Course> getCourses();
    Course addStudentToCourse(Long courseId, Long studentId);
    List<Student> getStudents(Long courseId);
}