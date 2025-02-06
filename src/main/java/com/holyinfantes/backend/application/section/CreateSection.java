package com.holyinfantes.backend.application.section;


import com.holyinfantes.backend.domain.section.Section;
import com.holyinfantes.backend.infrastructure.repository.section.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class CreateSection {

    @Autowired
    private SectionRepository sectionRepository;

    public void saveSection(String name, Map<String, Object> content, int order) {

        Section section = new Section();
        section.setName(name);
        section.setContent(content);
        section.setOrder(order);
        section.setCreatedAt(LocalDateTime.now());
        section.setUpdatedAt(LocalDateTime.now());
        sectionRepository.insert(section);
    }

}
