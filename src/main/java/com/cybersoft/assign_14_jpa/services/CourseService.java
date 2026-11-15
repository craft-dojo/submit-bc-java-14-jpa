package com.cybersoft.assign_14_jpa.services;

import com.cybersoft.assign_14_jpa.request.InsertCourseRequestDTO;
import com.cybersoft.assign_14_jpa.response.CourseResponseDTO;

public interface CourseService {
    CourseResponseDTO insertCourse(InsertCourseRequestDTO request);
}
