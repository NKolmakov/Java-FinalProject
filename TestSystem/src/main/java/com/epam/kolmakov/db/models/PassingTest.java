package com.epam.kolmakov.db.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassingTest {
    private Long id;
    private Long testId;
    private Long userId;
    private Short rightQuestionsAmount;
    private Short wrongQuestionsAmount;
    private Test test;
    private User user;

    public PassingTest(Long id, Long testId, Long userId, Short rightQuestionsAmount, Short wrongQuestionsAmount) {
        this.id = id;
        this.testId = testId;
        this.userId = userId;
        this.rightQuestionsAmount = rightQuestionsAmount;
        this.wrongQuestionsAmount = wrongQuestionsAmount;
    }
}
