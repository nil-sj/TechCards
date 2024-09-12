package com.techcards.techcards_api.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tags", uniqueConstraints = {
        @UniqueConstraint(name = "unique_tag_name", columnNames = "name")
}, indexes = {
        @Index(name = "idx_tag_category", columnList = "category")
})
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TagCategory category;

    @Column(length = 2048)
    private String image; // URL for the image

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    // Default constructor
    public Tag() {}

    // Parameterized constructor
    public Tag(String name, String description, TagCategory category, String image) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.image = image;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TagCategory getCategory() {
        return category;
    }

    public void setCategory(TagCategory category) {
        this.category = category;
    }

    public String getImage() {
        return image;
    }

    /**
     * Reminder: Implement URL format validation for the image field in the service layer.
     * - Ensure the value provided for the image field follows a valid URL format.
     * - Consider using a utility method or regular expression (regex) to validate the URL.
     * - The validation should be done before persisting or updating the Tag entity.
     */
    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    // Method to return display name of category
    public String getCategoryDisplayName() {
        return this.category.getDisplayName();
    }

    // Lifecycle methods for auditing

    /**
     * onCreate() - This method is triggered automatically before the entity is persisted (saved) in the database.
     * - Sets both the createdDate and updatedDate to the current date and time.
     * - Use createdDate to track when the entity (Tag) was first created in the system.
     * - Use updatedDate to reflect the time when the entity was last updated (initially set to the creation time).
     *
     * onUpdate() - This method is triggered automatically before the entity is updated in the database.
     * - Updates the updatedDate field to the current date and time.
     * - Use updatedDate to track the last modification time whenever any changes are made to the entity.
     */

    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now(); // Also set at creation
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}