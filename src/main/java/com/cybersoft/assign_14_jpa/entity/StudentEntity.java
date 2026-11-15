package com.cybersoft.assign_14_jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "students")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<CourseEntity> courses = new ArrayList<>();

    public void addCourse(CourseEntity course) {
        this.courses.add(course);
        course.getStudents().add(this);
    }

    public void removeCourse(CourseEntity course) {
        this.courses.remove(course);
        course.getStudents().remove(this);
    }
}
