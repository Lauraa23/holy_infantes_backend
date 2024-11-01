package com.holyinfantes.backend.domain.courseorder.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CourseOrderExceptionHandler {

    @ExceptionHandler(CourseAlreadyAdquiredException.class)
    public ResponseEntity<String> handleCourseAlreadyAdquiredException(CourseAlreadyAdquiredException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }
}
