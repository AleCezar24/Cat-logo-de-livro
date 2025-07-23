package com.example.bookcatalog.service;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class GutendexClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "https://gutendex.com/books/";

    public List<BookDto> fetchAllBooks(int page) {
        var response = restTemplate.getForObject(API_URL + "?page=" + page, GutendexResponse.class);
        return response == null ? List.of() : response.results;
    }

    record GutendexResponse(
        @JsonProperty("results") List<BookDto> results
    ) {}
}
