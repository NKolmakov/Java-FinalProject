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
    private String text;
    private List<Answer> answers;
}
