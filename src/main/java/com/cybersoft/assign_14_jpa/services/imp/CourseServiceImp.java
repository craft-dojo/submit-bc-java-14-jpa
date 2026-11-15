package com.cybersoft.assign_14_jpa.services.imp;

import com.cybersoft.assign_14_jpa.entity.CourseEntity;
import com.cybersoft.assign_14_jpa.repository.CourseRepository;
import com.cybersoft.assign_14_jpa.request.InsertCourseRequestDTO;
import com.cybersoft.assign_14_jpa.response.CourseResponseDTO;
import com.cybersoft.assign_14_jpa.services.CourseService;
import jakarta.persistence.EntityExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImp implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseServiceImp(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public CourseResponseDTO insertCourse(InsertCourseRequestDTO request) {
        if (courseRepository.existsByTitle(request.getTitle())) {
            throw new EntityExistsException("Title already exists");
        }

        CourseEntity newCourse = CourseEntity.builder()
                .title(request.getTitle())
                .build();

        CourseEntity createdCourse = courseRepository.save(newCourse);
        return CourseResponseDTO.mapToDTO(createdCourse);
    }
}
