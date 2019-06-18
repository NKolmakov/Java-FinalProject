package com.epam.kolmakov.db.dao.subject;

import com.epam.kolmakov.db.dao.abstractDao.CrudDao;
import com.epam.kolmakov.db.models.Subject;

import java.util.Optional;

public interface SubjectDao extends CrudDao<Subject> {
    Optional<Subject> findSubjectByName(String name);
    Long saveAndGetId(Subject subject);
}
