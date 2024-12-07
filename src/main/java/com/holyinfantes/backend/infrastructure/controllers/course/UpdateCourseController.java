package com.holyinfantes.backend.infrastructure.controllers.course;

import com.holyinfantes.backend.application.course.UpdateCourse;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/updateCourse")
public class UpdateCourseController {

    @Autowired
    private UpdateCourse updateCourse;

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCourse(
            @PathVariable String id,
            @RequestBody UpdateCourseRequest updateCourseRequest) {

        updateCourse.updateCourse(
                id,
                updateCourseRequest.getTitle(),
                updateCourseRequest.getDescription(),
                updateCourseRequest.getPrice(),
                updateCourseRequest.getVideoUrl()
        );

        return new ResponseEntity<>("Course updated successfully", HttpStatus.OK);
    }

    @Data
    public static class UpdateCourseRequest {
        private String title;
        private String description;
        private Long price;
        private String videoUrl;
    }
}
