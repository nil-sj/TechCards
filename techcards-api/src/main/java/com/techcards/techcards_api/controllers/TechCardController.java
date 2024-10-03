package com.techcards.techcards_api.controllers;


import com.techcards.techcards_api.exception.ResourceNotFoundException;
import com.techcards.techcards_api.models.TechCard;
import com.techcards.techcards_api.services.TechCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/techcards")
public class TechCardController {

    private final TechCardService techCardService;

    @Autowired
    public TechCardController(TechCardService techCardService) {
        this.techCardService = techCardService;
    }

    // Create a new TechCard
    @PostMapping
    public ResponseEntity<TechCard> createTechCard(@Valid @RequestBody TechCard techCard) {
        TechCard createdTechCard = techCardService.createTechCard(techCard);
        return ResponseEntity.status(201).body(createdTechCard);
    }

    // Get all TechCards
    @GetMapping
    public ResponseEntity<List<TechCard>> getAllTechCards() {
        List<TechCard> techCards = techCardService.getAllTechCards();
        return ResponseEntity.ok(techCards);
    }

    // Get TechCard by ID
    @GetMapping("/{id}")
    public ResponseEntity<TechCard> getTechCardById(@PathVariable Long id) {
        TechCard techCard = techCardService.getTechCardById(id)
                .orElseThrow(() -> new ResourceNotFoundException("TechCard not found with id " + id));
        return ResponseEntity.ok(techCard);
    }

    // Update TechCard
    @PutMapping("/{id}")
    public ResponseEntity<TechCard> updateTechCard(@PathVariable Long id, @Valid @RequestBody TechCard techCardDetails) {
        TechCard updatedTechCard = techCardService.updateTechCard(id, techCardDetails);
        return ResponseEntity.ok(updatedTechCard);
    }

    // Delete TechCard
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTechCard(@PathVariable Long id) {
        techCardService.deleteTechCard(id);
        return ResponseEntity.noContent().build();
    }
}