package com.holyinfantes.backend.infrastructure.repository.section;

import com.holyinfantes.backend.domain.section.LandingSection;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LandingSectionRepository extends MongoRepository<LandingSection, String> {
}
