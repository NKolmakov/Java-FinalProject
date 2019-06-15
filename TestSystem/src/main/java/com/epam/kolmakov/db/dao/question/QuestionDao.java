package com.epam.kolmakov.db.dao.question;

import com.epam.kolmakov.db.dao.abstractDao.CrudDao;
import com.epam.kolmakov.db.models.Question;

public interface QuestionDao extends CrudDao<Question> {
    Long saveAndGetId(Question question);
}
