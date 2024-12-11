package com.holyinfantes.backend.infrastructure.controllers.section;

import com.holyinfantes.backend.application.section.GetAllSections;
import com.holyinfantes.backend.domain.section.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/getAllSections")
public class GetAllSectionsController {

    @Autowired
    private GetAllSections getAllSections;

    @GetMapping
    public ResponseEntity<List<Section>> getAllSections() {
        return new ResponseEntity<>(getAllSections.getAllSections(), HttpStatus.OK);
    }
}
