package com.epam.kolmakov.db.dao.answer;

import com.epam.kolmakov.db.dao.abstractDao.AbstractDao;
import com.epam.kolmakov.db.models.Answer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//todo:fill
@Component
public class AnswerDaoImpl extends AbstractDao<Answer> implements AnswerDao {
    //language=SQL
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM answer WHERE id = :id";
    //language=SQL
    private static final String SQL_INSERT_INTO_ANSWER = "INSERT " +
            "INTO answer(question_id, text, correct)" +
            "VALUES (:questionId,:text,:isCorrect)";
    //language=SQL
    private static final String SQL_SELECT_ALL = "SELECT * FROM answer";
    //language=SQL
    private static final String SQL_SELECT_BY_QUESTION_ID = "SELECT * FROM answer WHERE question_id = :id";
    @Override
    public Optional<Answer> findById(Long id) {
        Map<String,Long> params = new HashMap<>();
        params.put("id",id);
        return findById(SQL_SELECT_BY_ID,params,answerRowMapper());
    }

    @Override
    public boolean save(Answer model) {
        Map<String,Object> params = new HashMap<>();
        params.put("questionId",model.getQuestionId());
        params.put("text",model.getAnswerText());
        params.put("isCorrect",model.isRight());
        return save(SQL_INSERT_INTO_ANSWER,params);
    }

    @Override
    public boolean update(Answer model) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Answer> findAll() {
        return findAll(SQL_SELECT_ALL,answerRowMapper());
    }

    @Override
    public List<Answer> getAnswersByQuestionId(Long id) {
        Map<String,Long> params = new HashMap<>();
        params.put("id",id);
        return namedParameterJdbcTemplate.query(SQL_SELECT_BY_QUESTION_ID,params,answerRowMapper());
    }

    private RowMapper<Answer> answerRowMapper(){
        return ((resultSet, i) -> {
            Answer answer = new Answer(
                    resultSet.getLong("id"),
                    resultSet.getLong("question_id"),
                    resultSet.getString("text"),
                    resultSet.getBoolean("correct")
            );
            return answer;
        });
    }
}
