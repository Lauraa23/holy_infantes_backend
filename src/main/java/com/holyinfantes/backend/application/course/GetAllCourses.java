package com.holyinfantes.backend.application.course;


import com.holyinfantes.backend.domain.holyInfantes.course.Course;
import com.holyinfantes.backend.infrastructure.repository.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCourses {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }
}
