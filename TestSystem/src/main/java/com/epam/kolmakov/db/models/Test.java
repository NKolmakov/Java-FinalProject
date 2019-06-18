package com.epam.kolmakov.db.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Test {
    private Long id;
    private String name;
    private String description;
    private Long subjectId;
    private Subject subject;
    private List<Question> questions;

    public Test(String name, String description, List<Question> questions) {
        this.name = name;
        this.description = description;
        this.questions = questions;
    }

    public Test(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Test(Long id, String name, String description, Long subjectId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.subjectId = subjectId;
    }
}
