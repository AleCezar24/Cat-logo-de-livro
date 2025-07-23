package com.example.bookcatalog.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class BookDto {
    public Long id;
    public String title;

    @JsonProperty("authors")
    public List<AuthorDto> authors;

    @JsonProperty("download_count")
    public Integer downloadCount;

    public record AuthorDto(String name) {}
}
