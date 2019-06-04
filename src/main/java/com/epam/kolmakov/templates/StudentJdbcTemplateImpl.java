package com.epam.kolmakov.templates;

import com.epam.kolmakov.db.dao.StudentDao;
import com.epam.kolmakov.db.models.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class StudentJdbcTemplateImpl implements StudentJdbcTemplate {

    //language=SQL
    private static final String SQL_SELECT_ALL = "SELECT * FROM student";

    //language=SQL
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM student WHERE student_id = :id";

    //language=SQL
    private static final String SQL_SELECT_BY_FIRST_NAME = "SELECT * FROM student WHERE UPPER(first_name) LIKE (UPPER(:firstName))";

    //language=SQL
    private static final String SQL_INSERT_STUDENT =
            "INSERT INTO student(first_name, last_name,group_id)" +
                    "VALUES (:firstName,:lastName,:groupId)";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Student> findAllByFirstName(String firstName) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", firstName);

        return namedParameterJdbcTemplate.query(SQL_SELECT_BY_FIRST_NAME, params, studentRowMapper());
    }

    @Override
    public Optional<Student> find(Long id) {
        return Optional.empty();
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Student> findAll() {
       return namedParameterJdbcTemplate.query(SQL_SELECT_ALL,studentRowMapper());
    }

    @Override
    public void save(Student model) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", model.getFirstName());
        params.put("lastName", model.getLastName());
        if (model.getGroup() != null) {
            params.put("groupId", model.getGroup().getId());
        }

        namedParameterJdbcTemplate.update(SQL_INSERT_STUDENT, params);
    }

    @Override
    public void update(Student model) {

    }

    private RowMapper<Student> studentRowMapper() {
        return (resultSet, i) -> {
            Student student = new Student(
                    resultSet.getLong("student_id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name")
            );
            return student;
        };
    }
}
