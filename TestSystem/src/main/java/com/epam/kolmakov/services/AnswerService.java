package com.epam.kolmakov.services;

import com.epam.kolmakov.db.dao.answer.AnswerDao;
import com.epam.kolmakov.db.models.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService {
    @Autowired
    private AnswerDao answerDao;

    public Optional<Answer> getAnswerById(Long id){
       return answerDao.findById(id);
    }
}
