package com.cybersoft.assign_14_jpa.services.imp;

import com.cybersoft.assign_14_jpa.entity.StudentEntity;
import com.cybersoft.assign_14_jpa.repository.StudentRepository;
import com.cybersoft.assign_14_jpa.request.InsertStudentRequestDTO;
import com.cybersoft.assign_14_jpa.response.StudentResponseDTO;
import com.cybersoft.assign_14_jpa.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
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
}
