package com.techcards.techcards_api.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tech_cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is mandatory")
    @Size(max = 100)
    private String name;

    @NotBlank(message = "URL is mandatory")
    @Size(max = 255)
    private String url;

    @NotBlank(message = "Image url is mandatory")
    @Size(max = 255)
    private String image;

    @Column(length = 1000)
    private String description;
}
