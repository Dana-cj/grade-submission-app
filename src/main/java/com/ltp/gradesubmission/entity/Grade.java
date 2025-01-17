package com.ltp.gradesubmission.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
//!!!unique constraints when you don't want duplicates eg. you want only onr grade for a student at a course, like a year average
@Table(name = "grade", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"student_id", "course_id"})
})
@Getter
@Setter
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "score", nullable = false)
    private String score;

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    private Course course;

}
