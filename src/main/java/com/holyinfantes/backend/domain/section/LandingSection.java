package com.holyinfantes.backend.domain.section;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "landing_section")
public class LandingSection {

    @Id
    private String id;
    private String name;
    private Map<String, Object> content;
    private int order;
    private LocalDateTime createdAt;
    private  LocalDateTime updatedAt;

}
