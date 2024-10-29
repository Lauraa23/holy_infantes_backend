package com.holyinfantes.backend.domain.courseorder;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "course_order", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "pruchased_at", nullable = false)
    private LocalDate purchasedAt;


}
