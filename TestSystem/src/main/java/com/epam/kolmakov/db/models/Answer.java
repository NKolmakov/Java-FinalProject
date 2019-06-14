package com.epam.kolmakov.db.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Answer {
    private Long answerId;
    private Long questionId;
    private Integer questionNumber;
    private Question question;
    private String answerText;
    private Integer answerNumber;
    private boolean status;
    private boolean checked;

    public Answer(Long answerId, String text, boolean status) {
        this.answerId = answerId;
        this.answerText = text;
        this.status = status;
    }
}
