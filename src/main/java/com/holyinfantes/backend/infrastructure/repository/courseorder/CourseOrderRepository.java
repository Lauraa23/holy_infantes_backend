package com.holyinfantes.backend.infrastructure.repository.courseorder;

import com.holyinfantes.backend.domain.holyInfantes.courseorder.CourseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseOrderRepository extends JpaRepository<CourseOrder, Long> {
    Optional<CourseOrder> findOrderByCourseIdAndUserId(Long courseId, Long userId);
}
