package com.holyinfantes.backend.infrastructure.repository.section;

import com.holyinfantes.backend.domain.section.Section;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SectionRepository extends MongoRepository<Section, String> {
}
