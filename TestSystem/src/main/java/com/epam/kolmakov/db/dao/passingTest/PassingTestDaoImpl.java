package com.epam.kolmakov.db.dao.passingTest;

import com.epam.kolmakov.db.dao.abstractDao.AbstractDao;
import com.epam.kolmakov.db.models.PassingTest;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class PassingTestDaoImpl extends AbstractDao<PassingTest> implements PassingTestDao {
    //language=SQL
    private static final String SQL_INSERT_INTO_PASSING_TEST = "INSERT " +
            "INTO passing_test(test_id, user_id,right_questions_amount,wrong_questions_amount)" +
            "VALUES (:testId, :userId, :rightQuestions, :wrongQuestions)";

    @Override
    public Optional<PassingTest> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean save(PassingTest model) {
        Map<String, Object> params = new HashMap<>();
        params.put("testId", model.getTestId());
        params.put("userId", model.getUserId());
        params.put("rightQuestions", model.getRightQuestionsAmount());
        params.put("wrongQuestions", model.getWrongQuestionsAmount());
        return save(SQL_INSERT_INTO_PASSING_TEST, params);
    }

    @Override
    public boolean update(PassingTest model) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<PassingTest> findAll() {
        return null;
    }

    private RowMapper<PassingTest> passingTestRowMapper() {
        return (resultSet, i) -> {
            return new PassingTest(
                    resultSet.getLong("id"),
                    resultSet.getLong("test_id"),
                    resultSet.getLong("user_id"),
                    resultSet.getShort("right_questions_amount"),
                    resultSet.getShort("wrong_questions_amount")
            );
        };
    }
}
