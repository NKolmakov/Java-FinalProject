package com.epam.kolmakov.db.dao.test;

import com.epam.kolmakov.config.WebConfig;
import com.epam.kolmakov.db.dao.abstractDao.AbstractDao;
import com.epam.kolmakov.db.models.Test;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class TestDaoImpl extends AbstractDao<Test> implements TestDao {
    //language=SQL
    private static final String SQL_SELECT_NOT_PASSED_TESTS = "SELECT * FROM test t " +
            "WHERE t.id NOT IN(SELECT test_id FROM passing_test pt WHERE pt.user_id=:id)";
    //language=sql
    private static final String SQL_SELECT_TEST_BY_ID = "SELECT * FROM test WHERE id = :id";
    //language=sql
    private static final String SQL_INSERT_INTO_TEST = "INSERT " +
            "INTO test(name, description)" +
            "VALUES (:testName,:description)";
    //language=sql
    private static final String SQL_SELECT_ALL = "SELECT * FROM test";

    @Override
    public Optional<Test> findById(Long id) {
        Map<String,Long> params = new HashMap<>();
        params.put("id",id);
        return findById(SQL_SELECT_TEST_BY_ID,params,testRowMapper());
    }

    @Override
    public boolean save(Test model) {
        Map<String,Object> params = new HashMap<>();
        params.put("testName",model.getName());
        params.put("description",model.getDescription());
        return save(SQL_INSERT_INTO_TEST,params);
    }

    @Override
    public boolean update(Test model) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Test> findAll() {
        return findAll(SQL_SELECT_ALL,testRowMapper());
    }

    @Override
    public List<Test> getNotPassedTestsByUserId(Long id) {
        try {
            Map<String, Long> params = new HashMap<>();
            params.put("id", id);
            return namedParameterJdbcTemplate.query(SQL_SELECT_NOT_PASSED_TESTS, params, testRowMapper());
        }catch (Exception ex){
            WebConfig.LOGGER.warn(ex);
            return new ArrayList<>();
        }
    }

    @Override
    public Long saveAndGetId(Test test) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("testName",test.getName());
        parameterSource.addValue("description",test.getDescription());
        return saveAndGetId(SQL_INSERT_INTO_TEST,parameterSource);
    }

    private RowMapper<Test> testRowMapper() {
        return (resultSet, i) -> {
            Test test = new Test(
                    resultSet.getLong("id"),
                    resultSet.getString("name"),
                    resultSet.getString("description")
            );
            return test;
        };
    }
}
