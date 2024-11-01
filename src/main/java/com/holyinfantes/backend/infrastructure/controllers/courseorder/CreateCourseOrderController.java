//package com.holyinfantes.backend.infrastructure.controllers.courseorder;
//
//import com.holyinfantes.backend.application.courseorder.CreateCourseOrder;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@Validated
//@RestController
//public class CreateCourseOrderController {
//
//    @Autowired
//    private CreateCourseOrder service;
//
//    @PostMapping
//    public ResponseEntity<String> createOrder(@Valid @RequestBody Long courseId) {
//            service.createOrder(courseId);
//            return ResponseEntity.ok("Order created");
//    }
//}
