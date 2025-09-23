package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public record RepositoryResponse(String id,

                                @JsonProperty("html_url") String html_url,
                               @JsonProperty("private") boolean isPrivate) {
}
