package com.dana.gradesubmission.web;

import com.dana.gradesubmission.entity.Student;
import com.dana.gradesubmission.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
       Student student = studentService.getStudent(id);
       return new ResponseEntity<> (student, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Student> saveStudent(@RequestBody Student student){
        Student student1= studentService.saveStudent(student);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getStudents(){
        return new ResponseEntity<>(studentService.getStudents(), HttpStatus.OK);
    }

}
