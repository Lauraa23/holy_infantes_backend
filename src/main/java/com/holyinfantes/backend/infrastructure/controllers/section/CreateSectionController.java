package com.holyinfantes.backend.infrastructure.controllers.section;

import com.holyinfantes.backend.application.section.CreateSection;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/createSection")
public class CreateSectionController {

    @Autowired
    private CreateSection createSection;

    @PostMapping
    public ResponseEntity<String> createSection(
            @RequestBody CreateSectionRequest createSectionRequest) {
        createSection.saveSection(
                createSectionRequest.getName(),
                createSectionRequest.getContent(),
                createSectionRequest.getOrder()
        );
        return new ResponseEntity<>("Section created successfully", HttpStatus.CREATED);

    }

    @Data
    public static class CreateSectionRequest {
        private String name;
        private Map<String, Object> content;
        private int order;
    }
}
