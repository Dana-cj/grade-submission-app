package com.dana.gradesubmission.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NonNull
    @Column(name = "subject", nullable = false)
    private String subject;

    @NonNull
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @NonNull
    @Column(name = "description", nullable = false)
    private String description;


    @JsonIgnore
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<Grade> grades;


    @ManyToMany
    @JoinTable(name = "course_student", joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
            uniqueConstraints = {@UniqueConstraint(columnNames = {"course_id", "student_id"})}
    )
    private List<Student> students;

    public void addStudentToCourse(Student student){
        students.add(student);
    }
}
