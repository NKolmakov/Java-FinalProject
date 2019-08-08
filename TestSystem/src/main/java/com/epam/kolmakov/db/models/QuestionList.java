package com.epam.kolmakov.db.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionList {
    private Long id;
    private Long testId;
    private Long questionId;
    private Test test;
    private Question question;

    public QuestionList(Long id, Long testId, Long questionId) {
        this.id = id;
        this.testId = testId;
        this.questionId = questionId;
    }

    public QuestionList(Long testId, Long questionId) {
        this.testId = testId;
        this.questionId = questionId;
    }
}
