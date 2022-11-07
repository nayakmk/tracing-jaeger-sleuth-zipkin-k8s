package io.nayakmk.samples.tracing.controller;

import io.nayakmk.samples.tracing.model.Author;
import io.nayakmk.samples.tracing.model.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@EnableAutoConfiguration
public class LibraryController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${library.book.service}")
    String bookServiceUrl;

    @GetMapping(path = "/library/{userId}")
    public ResponseEntity<Book> findBooks(@PathVariable String userId) {
        ResponseEntity<Book> response = restTemplate.getForEntity(bookServiceUrl +
                "/book/1", Book.class);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body(response.getBody());
    }
}
