package com.holyinfantes.backend.application.course;


import com.holyinfantes.backend.domain.holyInfantes.course.Course;
import com.holyinfantes.backend.infrastructure.repository.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourse {

    @Autowired
    private CourseRepository courseRepository;

    public Course updateCourse(String id, String title, String description, Long price, String videoUrl) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));

        course.setTitle(title);
        course.setDescription(description);
        course.setPrice(price);
        course.setVideoUrl(videoUrl);

        return courseRepository.save(course);
    }
}
