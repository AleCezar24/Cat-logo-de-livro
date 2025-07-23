package com.example.bookcatalog.controller;

import com.example.bookcatalog.model.Book;
import com.example.bookcatalog.repository.BookRepository;
import com.example.bookcatalog.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository repo;
    private final BookService service;

    public BookController(BookRepository repo, BookService service) {
        this.repo = repo;
        this.service = service;
    }

    @GetMapping
    public List<Book> all() {
        return repo.findAll();
    }

    @PostMapping("/import/{pages}")
    public ResponseEntity<String> importBooks(@PathVariable int pages) {
        service.importBooks(pages);
        return ResponseEntity.ok("Importação concluída para " + pages + " páginas");
    }
}
