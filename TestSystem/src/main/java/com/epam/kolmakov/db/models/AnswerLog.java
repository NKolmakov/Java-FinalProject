package com.epam.kolmakov.db.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerLog {
    private Long id;
    private Long answerId;
    private Answer answer;
    private boolean checked;

    public AnswerLog(Long answerId, boolean checked) {
        this.answerId = answerId;
        this.checked = checked;
    }
}
