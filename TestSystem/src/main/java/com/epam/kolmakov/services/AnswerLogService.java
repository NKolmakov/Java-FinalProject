package com.epam.kolmakov.services;

import com.epam.kolmakov.db.dao.userAnswerLog.AnswerLogDao;
import com.epam.kolmakov.db.models.AnswerLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerLogService {
    @Autowired
    private AnswerLogDao answerLogDao;

    public boolean saveAnswerLog(AnswerLog answerLog){
        return answerLogDao.save(answerLog);
    }
}
