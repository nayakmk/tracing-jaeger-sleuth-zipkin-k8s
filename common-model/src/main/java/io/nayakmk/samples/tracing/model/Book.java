package io.nayakmk.samples.tracing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Book {
    public String title;

    public String author;

    public int year;

    public String publisher;

    public double cost;
}
