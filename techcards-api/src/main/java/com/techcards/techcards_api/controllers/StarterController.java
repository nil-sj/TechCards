package com.techcards.techcards_api.controllers;

import com.techcards.techcards_api.models.Starter;
import com.techcards.techcards_api.services.StarterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/starters")
public class StarterController {

    @Autowired
    private StarterService starterService;

    @GetMapping("/all")
    public List<Starter> getAllStarters() {
        return starterService.getAllStarters();
    }

    @GetMapping("/{starterId}")
    public Starter getStarter(@PathVariable Long starterId) {
        return starterService.getStarter(starterId);
    }

    @PostMapping("/new")
    public Starter createStarter(@RequestParam String message) {
        return starterService.createStarter(message);
    }

    @PutMapping("/update")
    public Starter updateStarter(@RequestBody Starter starter) {
        return starterService.updateStarter(starter);
    }

    @DeleteMapping("/delete/{starterId}")
    public String deleteStarter(@PathVariable Long starterId) {
        starterService.deleteStarter(starterId);
        return "Starter deleted successfully";
    }
}