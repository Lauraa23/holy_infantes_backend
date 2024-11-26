package com.holyinfantes.backend.application.course;

import com.holyinfantes.backend.domain.course.Course;
import com.holyinfantes.backend.infrastructure.repository.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class CreateCourse {

    @Autowired
    private CourseRepository courseRepository;

    public void saveCourse(String title, String description, Long price) {
        // 1--integracion con cloudinary para subir el video
        Course course = new Course();
        course.setTitle(title);
        course.setDescription(description);
        course.setPrice(price);
        course.setVideoUrl("test");

        courseRepository.insert(course);
    }
}
