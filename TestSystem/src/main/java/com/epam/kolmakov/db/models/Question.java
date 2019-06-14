package com.epam.kolmakov.db.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private Long id;
    private Integer number;
    private String text;
    private List<Answer> answers;

    public Question(Integer number, String text) {
        this.number = number;
        this.text = text;
    }

    public Question(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Question(Long id, String text, List<Answer> answers) {
        this.id = id;
        this.text = text;
        this.answers = answers;
    }
}
