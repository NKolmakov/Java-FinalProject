package com.epam.kolmakov.db.dao.question;

import com.epam.kolmakov.db.dao.abstractDao.AbstractDao;
import com.epam.kolmakov.db.models.Question;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
//todo:empty
public class QuestionDaoImpl extends AbstractDao<Question> implements QuestionDao {
    //language=sql
    private static final String SQL_INSERT_INTO_QUESTION = "INSERT " +
            "INTO question(text)" +
            "VALUES (:text)";
    //language=sql
    private static final String SQL_SELECT_QUESTIONS_BY_TEST_ID = "SELECT q2.id,q2.text " +
            "FROM question_list q INNER JOIN question q2 on q.question_id = q2.id " +
            "WHERE test_id = :id";

    @Override
    public Optional<Question> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean save(Question model) {
        return false;
    }

    @Override
    public boolean update(Question model) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Question> findAll() {
        return null;
    }

    @Override
    public Long saveAndGetId(Question question) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("text",question.getText());
        return saveAndGetId(SQL_INSERT_INTO_QUESTION,parameterSource);
    }

    @Override
    public List<Question> getQuestionsByTestId(Long id) {
        Map<String,Long> params = new HashMap<>();
        params.put("id",id);
        return namedParameterJdbcTemplate.query(SQL_SELECT_QUESTIONS_BY_TEST_ID,params,questionRowMapper());
    }
    
    private RowMapper<Question> questionRowMapper(){
        return ((resultSet, i) -> {
           Question question = new Question(
                   resultSet.getLong("id"),
                   resultSet.getString("text")
           ); 
           return question;
        });
    }
}
