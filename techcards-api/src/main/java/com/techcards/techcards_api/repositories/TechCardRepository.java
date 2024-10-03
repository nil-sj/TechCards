package com.techcards.techcards_api.repositories;


import com.techcards.techcards_api.models.TechCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechCardRepository extends JpaRepository<TechCard, Long> {
}