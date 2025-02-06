package com.holyinfantes.backend.domain.holyInfantes.course;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "course")
public class Course {

    @Id
    private String id;

    private String title;
    private String description;
    private Long price;
    private String videoUrl;
}
