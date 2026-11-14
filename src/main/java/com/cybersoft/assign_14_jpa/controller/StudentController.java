package com.cybersoft.assign_14_jpa.controller;

import com.cybersoft.assign_14_jpa.request.InsertStudentRequestDTO;
import com.cybersoft.assign_14_jpa.response.BaseResponse;
import com.cybersoft.assign_14_jpa.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<BaseResponse> getStudents() {
        BaseResponse res = BaseResponse.success(studentService.getAllStudents(), null, null);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> insertStudent(@RequestBody InsertStudentRequestDTO request) {
        BaseResponse res = BaseResponse.success(studentService.insertStudent(request), "Created successful", null);
        return ResponseEntity.ok(res);
    }
}
