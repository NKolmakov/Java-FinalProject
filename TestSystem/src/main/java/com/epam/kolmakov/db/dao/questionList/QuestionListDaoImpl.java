package com.epam.kolmakov.db.dao.questionList;

import com.epam.kolmakov.db.dao.abstractDao.AbstractDao;
import com.epam.kolmakov.db.models.QuestionList;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//todo: fill
@Component
public class QuestionListDaoImpl extends AbstractDao<QuestionList> implements QuestionListDao {
    //language=sql
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM question_list WHERE id = :id";
    //language=sql
    private static final String SQL_INSERT_INTO_QUESTION_LIST = "INSERT " +
            "INTO question_list(test_id, question_id)" +
            "VALUES (:testId,:questionId)";
    //language=sql
    private static final String SQL_SELECT_ALL = "SELECT * FROM question_list";
    //language=sql
    private static final String SQL_SELECT_SCOPE_IDENTITY = "SELECT LAST_INSERT_ID() from test";
    @Override
    public Optional<QuestionList> findById(Long id) {
        Map<String,Long> params = new HashMap<>();
        params.put("id",id);
        return findById(SQL_SELECT_BY_ID,params,questionListRowMapper());
    }

    @Override
    public boolean save(QuestionList model) {
        Map<String,Object> params = new HashMap<>();
        params.put("testId",model.getTestId());
        params.put("questionId",model.getQuestionId());
        return save(SQL_INSERT_INTO_QUESTION_LIST,params);
    }

    @Override
    public boolean update(QuestionList model) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<QuestionList> findAll() {
        return findAll(SQL_SELECT_ALL,questionListRowMapper());
    }

    private RowMapper<QuestionList> questionListRowMapper(){
        return ((resultSet, i) -> {
           QuestionList questionList = new QuestionList(
                   resultSet.getLong("id"),
                   resultSet.getLong("test_id"),
                   resultSet.getLong("question_id")
           );
           return questionList;
        });
    }
}
