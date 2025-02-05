package com.holyinfantes.backend.application.section;

import com.holyinfantes.backend.domain.section.Section;
import com.holyinfantes.backend.infrastructure.repository.section.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllSections {

    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }
}
