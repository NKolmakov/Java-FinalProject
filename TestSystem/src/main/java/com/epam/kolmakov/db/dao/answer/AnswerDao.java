package com.epam.kolmakov.db.dao.answer;

import com.epam.kolmakov.db.dao.abstractDao.CrudDao;
import com.epam.kolmakov.db.models.Answer;

import java.util.List;

public interface AnswerDao extends CrudDao<Answer> {
    List<Answer> getAnswersByQuestionId(Long id);
}
