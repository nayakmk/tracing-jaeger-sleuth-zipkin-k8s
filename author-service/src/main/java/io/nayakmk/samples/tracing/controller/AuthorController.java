package io.nayakmk.samples.tracing.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.nayakmk.samples.tracing.model.Author;

@RestController
public class AuthorController {
    @GetMapping(path = "/author/{id}")
    public ResponseEntity<Author> getBook(@PathVariable String id){
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(Author.builder().id("1").name("Gary Cornell").build());
    }
}
