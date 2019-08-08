package com.epam.kolmakov.forms;

import com.epam.kolmakov.db.models.Answer;
import com.epam.kolmakov.db.models.Question;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTestForm {
    private String testName;
    private String testDescription;
    private String subjectName;
    private List<Question> questions;
    private List<Answer> answers;

    public List<Answer> getAnswersByQuestionNumber(Integer questionNumber){
        List<Answer> answerList = new ArrayList<>();
        for (Answer answer:answers){
            if(answer.getQuestionNumber() != null && answer.getQuestionNumber().equals(questionNumber)){
                answerList.add(answer);
            }
        }
        return answerList;
    }
}
