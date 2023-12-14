package org.example.boot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class Person {
    private final UUID id;
    @NotBlank
    private final String name;

    @NotNull
    @Min(0)
    private final Integer age;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
