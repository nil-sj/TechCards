package com.techcards.techcards_api.services;

import com.techcards.techcards_api.models.TechCard;

import java.util.List;
import java.util.Optional;

public interface TechCardService {
    TechCard createTechCard(TechCard techCard);
    List<TechCard> getAllTechCards();
    Optional<TechCard> getTechCardById(Long id);
    TechCard updateTechCard(Long id, TechCard techCard);
    void deleteTechCard(Long id);
}
