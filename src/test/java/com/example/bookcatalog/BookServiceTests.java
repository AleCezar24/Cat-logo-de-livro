package com.example.bookcatalog;

import com.example.bookcatalog.repository.BookRepository;
import com.example.bookcatalog.service.BookService;
import com.example.bookcatalog.service.GutendexClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTests {

    @Test
    void testImportBooks_runsWithoutErrors() {
        var repo = Mockito.mock(BookRepository.class);
        var client = Mockito.mock(GutendexClient.class);

        var service = new BookService(client, repo);

        // Só testamos se executa sem lançar exceções
        service.importBooks(1);
    }
}
