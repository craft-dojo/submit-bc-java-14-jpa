package com.cybersoft.assign_14_jpa.services.imp;

import com.cybersoft.assign_14_jpa.entity.CourseEntity;
import com.cybersoft.assign_14_jpa.entity.StudentEntity;
import com.cybersoft.assign_14_jpa.repository.CourseRepository;
import com.cybersoft.assign_14_jpa.repository.StudentRepository;
import com.cybersoft.assign_14_jpa.request.InsertStudentRequestDTO;
import com.cybersoft.assign_14_jpa.response.CourseResponseDTO;
import com.cybersoft.assign_14_jpa.response.StudentResponseDTO;
import com.cybersoft.assign_14_jpa.services.StudentService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public StudentServiceImp(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(StudentResponseDTO::mapToDTO)
                .toList();
    }

    @Override
    public StudentResponseDTO insertStudent(InsertStudentRequestDTO request) {
        if (studentRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        StudentEntity newStudent = StudentEntity.builder()
                .email(request.getEmail())
                .name(request.getName())
                .build();

        StudentEntity createdStudent = studentRepository.save(newStudent);
        return StudentResponseDTO.mapToDTO(createdStudent);
    }

    @Override
    public List<CourseResponseDTO> getCoursesByStudentId(int studentId) {
        StudentEntity student = studentRepository.findByIdWithCourses(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student with id: " + studentId + " not found"));

        return student.getCourses()
                .stream()
                .map(CourseResponseDTO::mapToDTO)
                .toList();
    }

    @Override
    public StudentResponseDTO enrollCourse(int studentId, int courseId) {
        StudentEntity studentExisting = studentRepository.findByIdWithCourses(studentId)
                .orElseThrow(() -> new EntityNotFoundException("Student with id: " + studentId + " not found"));

        CourseEntity courseExisting = courseRepository.findById(courseId)
                .orElseThrow(() -> new  EntityNotFoundException("Course with id: " + courseId + " not found"));

        if (studentExisting.getCourses().contains(courseExisting)) {
            throw new  IllegalArgumentException("Course with id: " + courseId + " already exists");
        }

        courseExisting.getStudents().add(studentExisting);
        studentExisting.addCourse(courseExisting);
        studentRepository.save(studentExisting);

        return StudentResponseDTO.mapToDTO(studentExisting);
    }
}
