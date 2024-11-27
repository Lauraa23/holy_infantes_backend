package com.holyinfantes.backend.infrastructure.controllers.course;

import com.holyinfantes.backend.application.course.CreateCourse;
import com.holyinfantes.backend.domain.course.Course;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/createCourse")
public class CreateCourseController {

    @Autowired
    private CreateCourse createCourse;

    @PostMapping
    public ResponseEntity<String> createCourse(
            @RequestBody CreateCourseRequest createCourseRequest) {

        createCourse.saveCourse(createCourseRequest.getTitle(), createCourseRequest.getDescription(), createCourseRequest.getPrice());
        return new ResponseEntity<>("Course created successfully", HttpStatus.CREATED);
    }

    @Data
    public static class CreateCourseRequest {
        private String title;
        private String description;
        private Long price;
        private String videoUrl;


    }
}
