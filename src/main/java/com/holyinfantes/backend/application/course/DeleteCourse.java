package com.holyinfantes.backend.application.course;

import com.holyinfantes.backend.infrastructure.repository.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCourse {

    @Autowired
    private CourseRepository courseRepository;

    public void deleteCourseById(String id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        } else {
            throw new RuntimeException("No se ha podido encontrar ese curso");
        }
    }
}
