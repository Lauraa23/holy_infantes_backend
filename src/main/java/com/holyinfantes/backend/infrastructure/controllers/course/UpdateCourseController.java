package com.holyinfantes.backend.infrastructure.controllers.course;

import com.holyinfantes.backend.application.course.UpdateCourse;
import com.holyinfantes.backend.domain.course.Course;
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
    public ResponseEntity<Course> updateCourse(
            @PathVariable String id,
            @RequestBody UpdateCourseRequest updateCourseRequest) {

        Course updatedCourse = updateCourse.updateCourse(
                id,
                updateCourseRequest.getTitle(),
                updateCourseRequest.getDescription(),
                updateCourseRequest.getPrice(),
                updateCourseRequest.getVideoUrl()
        );

        return new ResponseEntity<>(updatedCourse, HttpStatus.OK);
    }

    public static class UpdateCourseRequest {
        private String title;
        private String description;
        private Long price;
        private String videoUrl;

        // Getters y Setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Long getPrice() {
            return price;
        }

        public void setPrice(Long price) {
            this.price = price;
        }

        public String getVideoUrl() {
            return videoUrl;
        }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
        }
    }
}
