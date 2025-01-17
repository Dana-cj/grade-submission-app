package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.Grade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface GradeRepository extends CrudRepository<Grade,Long> {
   Optional <Grade> findByStudentIdAndCourseId(Long studentId, Long courseId);
   @Transactional
   void deleteByStudentIdAndCourseId(Long studentId, Long courseId);
    List<Grade> findAllByStudentId(Long studentId);
    List<Grade> findAllByCourseId(Long courseId);
}