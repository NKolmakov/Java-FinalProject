package com.epam.kolmakov.db.dao.passingTest;

import com.epam.kolmakov.db.dao.abstractDao.AbstractDao;
import com.epam.kolmakov.db.models.PassingTest;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//todo: fill
@Component
public class PassingTestDaoImpl extends AbstractDao<PassingTest> implements PassingTestDao {

    //language=SQL
    private static final String SQL_INSERT_INTO_PASSING_TEST = "INSERT " +
            "INTO passing_test(test_id, user_id)" +
            "VALUES (:testId, :userId)";

    @Override
    public Optional<PassingTest> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean save(PassingTest model) {
        Map<String, Object> params = new HashMap<>();
        params.put("testId", model.getTestId());
        params.put("userId", model.getUserId());
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
                    resultSet.getLong("user_id")
            );
        };
    }
}
