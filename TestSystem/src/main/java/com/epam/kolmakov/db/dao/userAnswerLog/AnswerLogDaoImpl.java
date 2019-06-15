package com.epam.kolmakov.db.dao.userAnswerLog;

import com.epam.kolmakov.db.models.AnswerLog;

import java.util.List;
import java.util.Optional;

//todo: fill
public class AnswerLogDaoImpl implements AnswerLogDao {
    @Override
    public Optional<AnswerLog> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean save(AnswerLog model) {
        return false;
    }

    @Override
    public boolean update(AnswerLog model) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<AnswerLog> findAll() {
        return null;
    }
}
