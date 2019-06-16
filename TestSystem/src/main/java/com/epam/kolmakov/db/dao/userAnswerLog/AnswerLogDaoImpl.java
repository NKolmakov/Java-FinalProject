package com.epam.kolmakov.db.dao.userAnswerLog;

import com.epam.kolmakov.db.dao.abstractDao.AbstractDao;
import com.epam.kolmakov.db.models.AnswerLog;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//todo: fill
@Component
public class AnswerLogDaoImpl extends AbstractDao<AnswerLog> implements AnswerLogDao {
    //language=sql
    private static final String SQL_INSERT_ANSWER_LOG = "INSERT " +
            "INTO answer_log(answer_id, checked) " +
            "VALUES (:answerId,:checked)";

    @Override
    public Optional<AnswerLog> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public boolean save(AnswerLog model) {
        Map<String,Object> params = new HashMap<>();
        params.put("answerId",model.getAnswerId());
        params.put("checked",model.isChecked());
        return save(SQL_INSERT_ANSWER_LOG,params);
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
