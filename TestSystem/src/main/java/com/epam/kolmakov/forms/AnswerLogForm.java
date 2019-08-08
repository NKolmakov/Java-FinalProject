package com.epam.kolmakov.forms;

import com.epam.kolmakov.db.models.Answer;
import lombok.Data;

import java.util.List;

@Data
public class AnswerLogForm {
    private List<Answer> answers;
    private List<Answer> radioAns;
    private Long testId;
}
