package com.techcards.techcards_api.models;

public enum TagCategory {
    LANGUAGES("Languages"),
    AREAS_OF_DEVELOPMENT("Areas of Development"),
    RESOURCE_TYPES("Resource Types"),
    EXPERIENCE_LEVEL("Experience Level"),
    DEVELOPMENT_TOOLS("Development Tools"),
    PLATFORMS_AND_FRAMEWORKS("Platforms and Frameworks"),
    OPERATING_SYSTEMS("Operating Systems"),
    INDUSTRY_SPECIFIC_RESOURCES("Industry-Specific Resources"),
    BEST_PRACTICES_METHODOLOGIES("Best Practices and Methodologies"),
    SOFT_SKILLS_CAREER_DEVELOPMENT("Soft Skills and Career Development"),
    SPECIAL_TOPICS("Special Topics"),
    COMMUNITY_EVENTS("Community and Events"),
    OTHER("Other");

    private final String displayName;

    TagCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

