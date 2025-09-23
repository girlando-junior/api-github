package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RepositoryResponse(String id,
                                @JsonProperty("name") String name,
                                @JsonProperty("html_url") String html_url,
                                @JsonProperty("description") String description,
                                @JsonProperty("private") boolean isPrivate) {
}
