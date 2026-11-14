package com.cybersoft.assign_14_jpa.services;

import com.cybersoft.assign_14_jpa.request.InsertStudentRequestDTO;
import com.cybersoft.assign_14_jpa.response.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> getAllStudents();

    StudentResponseDTO insertStudent(InsertStudentRequestDTO request);
}
