package com.epam.kolmakov.db.dao.subject;

import com.epam.kolmakov.db.dao.abstractDao.AbstractDao;
import com.epam.kolmakov.db.models.Subject;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class SubjectDaoImpl extends AbstractDao<Subject> implements SubjectDao {
    //language=sql
    private static final String SQL_SELECT_SUBJECT_BY_NAME = "SELECT * FROM subject WHERE UPPER(`name`) = UPPER(:name)";
    //language=sql
    private static final String SQL_SELECT_ALL = "SELECT * FROM subject";
    //language=sql
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM subject WHERE id = :id";
    //language=sql
    private static final String SQL_INSERT_INTO_SUBJECT = "INSERT " +
            "INTO subject(`name`) VALUES (:name)";
    @Override
    public Optional<Subject> findById(Long id) {
        Map<String,Long> params = new HashMap<>();
        params.put("id",id);
        return findById(SQL_SELECT_BY_ID,params,subjectRowMapper());
    }

    @Override
    public boolean save(Subject model) {
        return false;
    }

    @Override
    public boolean update(Subject model) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public List<Subject> findAll() {
        return findAll(SQL_SELECT_ALL,subjectRowMapper());
    }

    @Override
    public Long saveAndGetId(Subject subject) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("name",subject.getName());
        return saveAndGetId(SQL_INSERT_INTO_SUBJECT,source);
    }

    @Override
    public Optional<Subject> findSubjectByName(String name) {
        Map<String,String> params = new HashMap<>();
        params.put("name",name);
        List<Subject> subjects = namedParameterJdbcTemplate.query(SQL_SELECT_SUBJECT_BY_NAME,params,subjectRowMapper());
        if(subjects.size() == 0){
            return Optional.empty();
        }
        return Optional.of(subjects.get(0));
    }

    private RowMapper<Subject> subjectRowMapper(){
        return ((resultSet, i) -> {
           Subject subject = new Subject(
                   resultSet.getLong("id"),
                   resultSet.getString("name")
           );
           return subject;
        });
    }
}
