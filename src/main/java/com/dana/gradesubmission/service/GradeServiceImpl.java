package com.dana.gradesubmission.service;

import com.dana.gradesubmission.entity.Grade;
import com.dana.gradesubmission.entity.Student;
import com.dana.gradesubmission.exception.GradeNotFoundException;
import com.dana.gradesubmission.repository.CourseRepository;
import com.dana.gradesubmission.repository.GradeRepository;
import com.dana.gradesubmission.repository.StudentRepository;
import com.dana.gradesubmission.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeRepository gradeRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;

    @Override
    public Grade getGrade(Long studentId, Long courseId) {
        Optional<Grade> grade= gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
        return unwrapGrade(grade, studentId, courseId);
    }

    @Override
    public Grade saveGrade(Grade grade, Long studentId, Long courseId) {
        Optional<Student> student= studentRepository.findById(studentId);
        Student unwrappedStudent= StudentServiceImpl.unwrapStudent(student, studentId);
        grade.setStudent(unwrappedStudent);
        Optional<Course> course=courseRepository.findById(courseId);
        Course unwrappedCourse= CourseServiceImpl.unwrapCourse(course, courseId);
        grade.setCourse(unwrappedCourse);
        return gradeRepository.save(grade);
    }

    @Override
    public Grade updateGrade(String score, Long studentId, Long courseId) {

        Optional<Grade> grade= gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
//        if(grade.isPresent()){
//            grade.get().setScore(score);
//          return gradeRepository.save(grade.get());
//        } else {
//            throw new GradeNotFoundException(studentId, courseId);
//        }
        Grade unwrappedGrade=unwrapGrade(grade, studentId, courseId);
        unwrappedGrade.setScore(score);
        return gradeRepository.save(unwrappedGrade);
    }

    @Override
    public void deleteGrade(Long studentId, Long courseId) {
//       Optional<Grade> grade= gradeRepository.findByStudentIdAndCourseId(studentId, courseId);
//        if(grade.isPresent()) {
//            gradeRepository.deleteById(grade.get().getId());
//        } else throw new GradeNotFoundException(studentId, courseId);
        gradeRepository.deleteByStudentIdAndCourseId(studentId, courseId);
    }

    @Override
    public List<Grade> getStudentGrades(Long studentId) {
      return gradeRepository.findAllByStudentId(studentId);
    }

    @Override
    public List<Grade> getCourseGrades(Long courseId) {
        return gradeRepository.findAllByCourseId(courseId);
    }

    @Override
    public List<Grade> getAllGrades() {
        return (List<Grade>) gradeRepository.findAll();
    }
    static Grade unwrapGrade(Optional<Grade> grade, Long studentId, Long courseId){
        if(grade.isPresent()) return grade.get();
        else throw new GradeNotFoundException(studentId, courseId);
    }

}
