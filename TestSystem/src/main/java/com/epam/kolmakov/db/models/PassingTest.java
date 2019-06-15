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
    private Test test;
    private User user;

    public PassingTest(Long id, Long testId, Long userId) {
        this.id = id;
        this.testId = testId;
        this.userId = userId;
    }
}
