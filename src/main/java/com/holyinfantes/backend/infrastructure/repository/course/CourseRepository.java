package com.holyinfantes.backend.infrastructure.repository.course;

import com.holyinfantes.backend.domain.course.Course;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CourseRepository extends MongoRepository<Course, String> {

}
