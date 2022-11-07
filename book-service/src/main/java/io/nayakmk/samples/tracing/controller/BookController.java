package io.nayakmk.samples.tracing.controller;

import io.nayakmk.samples.tracing.model.Book;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping(path = "/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(Book.builder().title("Core Java").author("Gary Cornell").build());
    }
}
