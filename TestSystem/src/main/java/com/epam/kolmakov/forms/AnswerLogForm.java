package com.epam.kolmakov.forms;

import com.epam.kolmakov.db.models.Answer;
import com.epam.kolmakov.db.models.Question;
import lombok.Data;

import java.util.List;

@Data
public class AnswerLogForm {
    private List<Answer> answers;
}
