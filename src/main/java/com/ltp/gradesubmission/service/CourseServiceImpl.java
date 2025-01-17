package com.ltp.gradesubmission.service;

import com.ltp.gradesubmission.entity.Course;
import com.ltp.gradesubmission.entity.Student;
import com.ltp.gradesubmission.exception.CourseNotFoundException;
import com.ltp.gradesubmission.repository.CourseRepository;
import com.ltp.gradesubmission.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor

@Service
public class CourseServiceImpl implements CourseService {
    CourseRepository courseRepository;
    StudentRepository studentRepository;

    @Override
    public Course getCourse(Long id) {
        Optional<Course> course= courseRepository.findById(id);
//        if(course.isPresent()){
//            return  course.get();
//        } else {
//            throw new CourseNotFoundException(id);
//        }
        return unwrapCourse(course, id);
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<Course> getCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    static Course unwrapCourse(Optional<Course> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new CourseNotFoundException(id);
    }
    @Override
    public Course addStudentToCourse(Long course_id, Long student_id){
       Course course= unwrapCourse(courseRepository.findById(course_id), course_id);
       Student student=StudentServiceImpl.unwrapStudent(studentRepository.findById(student_id), student_id);
       course.addStudentToCourse(student);
       return courseRepository.save(course);
    }
    @Override
    public List<Student> getStudents(Long courseId){
        return unwrapCourse(courseRepository.findById(courseId), courseId).getStudents();
    }

}
