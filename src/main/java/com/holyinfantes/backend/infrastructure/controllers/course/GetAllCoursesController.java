package com.holyinfantes.backend.infrastructure.controllers.course;


import com.holyinfantes.backend.application.course.GetAllCourses;
import com.holyinfantes.backend.domain.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/getAllCourses")
public class GetAllCoursesController {

    @Autowired
    private GetAllCourses getAllCourses;

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return new ResponseEntity<>(getAllCourses.getAllCourses(), HttpStatus.OK);
    }
}
