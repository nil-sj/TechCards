package com.techcards.techcards_api.services.impl;

import com.techcards.techcards_api.exception.ResourceNotFoundException;
import com.techcards.techcards_api.models.TechCard;
import com.techcards.techcards_api.repositories.TechCardRepository;
import com.techcards.techcards_api.services.TechCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechCardServiceImpl implements TechCardService {

    private final TechCardRepository techCardRepository;

    @Autowired
    public TechCardServiceImpl(TechCardRepository techCardRepository) {
        this.techCardRepository = techCardRepository;
    }

    @Override
    public TechCard createTechCard(TechCard techCard) {
        return techCardRepository.save(techCard);
    }

    @Override
    public List<TechCard> getAllTechCards() {
        return techCardRepository.findAll();
    }

    @Override
    public Optional<TechCard> getTechCardById(Long id) {
        return techCardRepository.findById(id);
    }

    @Override
    public TechCard updateTechCard(Long id, TechCard techCardDetails) {
        return techCardRepository.findById(id).map(techCard -> {
            techCard.setName(techCardDetails.getName());
            techCard.setUrl(techCardDetails.getUrl());
            techCard.setImage(techCardDetails.getImage());
            techCard.setDescription(techCardDetails.getDescription());
            return techCardRepository.save(techCard);
        }).orElseThrow(() -> new ResourceNotFoundException("TechCard not found with id " + id));
    }

    @Override
    public void deleteTechCard(Long id) {
        TechCard techCard = techCardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TechCard not found with id " + id));
        techCardRepository.delete(techCard);
    }
}
