package com.epam.kolmakov.db.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnswerLog {
    private Long id;
    private PassingTest passingTest;
    private Answer answer;
    private boolean checked;
}
