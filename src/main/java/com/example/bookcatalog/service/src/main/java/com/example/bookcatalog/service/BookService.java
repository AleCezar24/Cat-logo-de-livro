package com.example.bookcatalog.service;

import com.example.bookcatalog.model.Book;
import com.example.bookcatalog.repository.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final GutendexClient client;
    private final BookRepository repo;

    public BookService(GutendexClient client, BookRepository repo) {
        this.client = client;
        this.repo = repo;
    }

    @Transactional
    public void importBooks(int pages) {
        for (int i = 1; i <= pages; i++) {
            client.fetchAllBooks(i).stream()
                .map(dto -> {
                    Book b = new Book();
                    b.setId(dto.id);
                    b.setTitle(dto.title);
                    b.setAuthors(
                        dto.authors.stream()
                            .map(BookDto.AuthorDto::name)
                            .reduce((a, b2) -> a + ", " + b2)
                            .orElse("")
                    );
                    b.setDownloadCount(dto.downloadCount);
                    return b;
                })
                .forEach(repo::save);
        }
    }
}
