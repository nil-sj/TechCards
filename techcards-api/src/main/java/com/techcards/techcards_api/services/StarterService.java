package com.techcards.techcards_api.services;

import com.techcards.techcards_api.models.Starter;
import com.techcards.techcards_api.repositories.StarterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StarterService {

    @Autowired
    private StarterRepository starterRepository;

    public List<Starter> getAllStarters() {
        return starterRepository.findAll();
    }

    public Starter getStarter(Long starterId) {
        return starterRepository.findById(starterId).orElse(null);
    }

    public Starter createStarter(String message) {
        Starter newStarter = new Starter(message);
        return starterRepository.save(newStarter);
    }

    public Starter updateStarter(Starter starter) {
        return starterRepository.save(starter);
    }

    public void deleteStarter(Long starterId) {
        starterRepository.deleteById(starterId);
    }
}
