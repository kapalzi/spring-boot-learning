package com.kapala.gifts.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Present {

    private final UUID id;
    @NotBlank
    private final String title;
    private final String depiction;
    private final String quantity;
    private final String price;
    @NotBlank
    private final String categoryId;
    private final String link;
    private final String isReserved;
    @NotBlank
    private final String registry;

    public Present(@JsonProperty("id") UUID id,
                   @JsonProperty("title") String title,
                   @JsonProperty("depiction") String depiction,
                   @JsonProperty("quantity") String quantity,
                   @JsonProperty("price") String price,
                   @JsonProperty("categoryId") String categoryId,
                   @JsonProperty("link") String link,
                   @JsonProperty("isReserved") String isReserved,
                   @JsonProperty("registry") String registry) {
        this.id = id;
        this.title = title;
        this.depiction = depiction;
        this.quantity = quantity;
        this.price = price;
        this.categoryId = categoryId;
        this.link = link;
        this.isReserved = isReserved;
        this.registry = registry;
    }

    public String getTitle() {
        return title;
    }

    public String getDepiction() {
        return depiction;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getLink() {
        return link;
    }

    public String getIsReserved() {
        return isReserved;
    }

    public String getRegistry() {
        return registry;
    }

    public UUID getId() {
        return id;
    }
}

