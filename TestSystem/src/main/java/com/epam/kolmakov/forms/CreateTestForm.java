package com.epam.kolmakov.forms;

import com.epam.kolmakov.db.models.Answer;
import com.epam.kolmakov.db.models.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTestForm {
    private List<Question> questions;
    private List<Answer> answers;
}
