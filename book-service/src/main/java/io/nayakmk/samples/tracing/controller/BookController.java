package io.nayakmk.samples.tracing.controller;

import io.nayakmk.samples.tracing.model.Author;
import io.nayakmk.samples.tracing.model.Book;
import lombok.extern.slf4j.Slf4j;
import zipkin2.reporter.AsyncReporter;

import java.util.Arrays;

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

import brave.Span;
import brave.Tags;
import brave.Tracer;
import brave.Tracing;
import brave.baggage.BaggageField;
import brave.baggage.BaggagePropagation;
import brave.baggage.BaggagePropagationConfig.SingleBaggageField;
import brave.propagation.B3Propagation;
import brave.propagation.ExtraFieldPropagation;
import brave.propagation.ThreadLocalCurrentTraceContext;

@RestController
@EnableAutoConfiguration
@Slf4j
public class BookController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    Tracer tracer;

    @Value("${library.author.service}")
    String authorServiceUrl;

    @GetMapping(path = "/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable String id) {
        log.info("Baggage Value: {} ", tracer.currentSpan().context().toString());
        extraTracing();
        ResponseEntity<Author> response = restTemplate.getForEntity(authorServiceUrl +
                "/author/1", Author.class);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                .body(Book.builder().title("Core Java").author(response.getBody().getName()).build());
    }

    private void extraTracing() {
        Span initialSpan = tracer.currentSpan();
        // Configure your baggage field
        // Configure your baggage field
       BaggageField COUNTRY_CODE = BaggageField.create("country-code");
       BaggagePropagation.newFactoryBuilder(B3Propagation.FACTORY).add(SingleBaggageField.remote(COUNTRY_CODE))
       .build();
       COUNTRY_CODE.updateValue(initialSpan.context(), "FO");
       Tags.BAGGAGE_FIELD.tag(COUNTRY_CODE, initialSpan);
    }
}
