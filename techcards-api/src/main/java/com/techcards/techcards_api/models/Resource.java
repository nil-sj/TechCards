package com.techcards.techcards_api.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(length = 2048)  // URL length limit
    private String thumbnailImage;

    @Column(nullable = false, length = 2048)  // URL length limit
    private String primaryLink;

    @ElementCollection
    @CollectionTable(name = "resource_additional_links", joinColumns = @JoinColumn(name = "resource_id"))
    @Column(name = "additional_link", length = 2048)
    private List<String> additionalLinks;

//    @ManyToOne
//    @JoinColumn(name = "created_by_user_id", nullable = false)
//    private User createdBy;

    @ManyToMany
    @JoinTable(
            name = "resource_tags",
            joinColumns = @JoinColumn(name = "resource_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;

//    @ManyToMany(mappedBy = "favoriteResources")
//    private List<User> favoritedByUsers;

//    @ManyToMany(mappedBy = "likedResources")
//    private List<User> likedByUsers;

//    @OneToMany(mappedBy = "resource", cascade = CascadeType.ALL)
//    private List<Comment> comments;

    @Column(nullable = false)
    private Integer likesCount = 0;

    @Column(nullable = false)
    private Integer favoritesCount = 0;

    @Column(nullable = false)
    private Integer commentsCount = 0;

    @Column(nullable = false)
    private Integer viewsCount = 0;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;

    @Column
    private LocalDateTime updatedDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ResourceStatus status;

    // Default constructor
    public Resource() {}

    // Parameterized constructor
    public Resource(String title, String description, String thumbnailImage, String primaryLink) {
        this.title = title;
        this.description = description;
        this.thumbnailImage = thumbnailImage;
        this.primaryLink = primaryLink;
        //later add a parameter User createdBy and add the following line.
        //this.createdBy = createdBy;
    }

    // Getters and setters for all fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnailImage() {
        return thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }

    public String getPrimaryLink() {
        return primaryLink;
    }

    public void setPrimaryLink(String primaryLink) {
        this.primaryLink = primaryLink;
    }

    public List<String> getAdditionalLinks() {
        return additionalLinks;
    }

    public void setAdditionalLinks(List<String> additionalLinks) {
        this.additionalLinks = additionalLinks;
    }

//    public User getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(User createdBy) {
//        this.createdBy = createdBy;
//    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

//    public List<User> getFavoritedByUsers() {
//        return favoritedByUsers;
//    }
//
//    public void setFavoritedByUsers(List<User> favoritedByUsers) {
//        this.favoritedByUsers = favoritedByUsers;
//    }
//
//    public List<User> getLikedByUsers() {
//        return likedByUsers;
//    }
//
//    public void setLikedByUsers(List<User> likedByUsers) {
//        this.likedByUsers = likedByUsers;
//    }
//
//    public List<Comment> getComments() {
//        return comments;
//    }
//
//    public void setComments(List<Comment> comments) {
//        this.comments = comments;
//    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public Integer getFavoritesCount() {
        return favoritesCount;
    }

    public void setFavoritesCount(Integer favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Integer getViewsCount() {
        return viewsCount;
    }

    public void setViewsCount(Integer viewsCount) {
        this.viewsCount = viewsCount;
    }

    public ResourceStatus getStatus() {
        return status;
    }

    public void setStatus(ResourceStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    // Lifecycle hooks for auditing
    @PrePersist
    protected void onCreate() {
        this.createdDate = LocalDateTime.now();
        this.updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedDate = LocalDateTime.now();
    }
}
