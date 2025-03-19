package com.holyinfantes.backend.infrastructure.controllers.course;


import com.holyinfantes.backend.application.course.DeleteCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deleteCourse")
public class DeleteCourseController {

    @Autowired
    private DeleteCourse deleteCourse;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable String id) {
        deleteCourse.deleteCourseById(id);
        return ResponseEntity.noContent().build();
    }
}
