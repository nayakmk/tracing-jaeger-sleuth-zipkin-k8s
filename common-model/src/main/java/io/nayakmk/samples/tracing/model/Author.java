package io.nayakmk.samples.tracing.model;

import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class Author {
    private String id;
    private String name;
}
