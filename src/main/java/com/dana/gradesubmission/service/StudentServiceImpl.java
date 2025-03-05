package com.dana.gradesubmission.service;

import com.dana.gradesubmission.entity.Student;
import com.dana.gradesubmission.exception.StudentNotFoundException;
import com.dana.gradesubmission.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public Student getStudent(Long id) {
       Optional <Student> student= studentRepository.findById(id);
       return unwrapStudent(student, id);
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getStudents() {
       return (List<Student>) studentRepository.findAll();

    }

 static Student unwrapStudent(Optional<Student> student, Long id){
        if(student.isPresent()){
            return student.get();
        } else {
            throw new StudentNotFoundException(id);
        }
 }


}