package com.epam.kolmakov.db.dao.test;

import com.epam.kolmakov.db.dao.abstractDao.CrudDao;
import com.epam.kolmakov.db.models.Test;

import java.util.List;

public interface TestDao extends CrudDao<Test> {
    Long saveAndGetId(Test test);
    List<Test> getNotPassedTestsByUserId(Long id);
}
