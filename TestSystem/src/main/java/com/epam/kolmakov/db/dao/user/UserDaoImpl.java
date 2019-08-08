package com.epam.kolmakov.db.dao.user;

import com.epam.kolmakov.config.WebConfig;
import com.epam.kolmakov.db.dao.abstractDao.AbstractDao;
import com.epam.kolmakov.db.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class UserDaoImpl extends AbstractDao<User> implements UserDao {

    //language=SQL
    private static final String SQL_SELECT_ALL = "SELECT * FROM user";
    //language=SQL
    private static final String SQL_SELECT_BY_ID = "SELECT * FROM user WHERE id = :id";
    //language=SQL
    private static final String SQL_SELECT_BY_FIRST_NAME = "SELECT * FROM user WHERE UPPER(first_name) LIKE (UPPER(:firstName))";
    //language=SQL
    private static final String SQL_INSERT_USER =
            "INSERT INTO user(first_name, last_name,role,group_id,login,password)" +
                    "VALUES (:firstName,:lastName,:role,:groupId,:login,:password)";
    //language=SQL
    private static final String SQL_SELECT_BY_LOGIN = "SELECT * FROM user WHERE binary login = :login";
    //language=SQL
    private static final String SQL_SELECT_BY_ROLE = "SELECT * FROM user WHERE UPPER(role) LIKE (UPPER(:role))";
    //language=SQL
    private static final String SQL_DELETE_BY_ID = "DELETE FROM user WHERE id = :id";
    //language=SQL
    private static final String SQL_UPDATE_BY_ID = "UPDATE user " +
            "set " +
            "id = :id," +
            "first_name = :firstName," +
            "last_name = :lastName," +
            "login = :login," +
            "password = :password," +
            "group_id = :groupId " +
            "WHERE id = :id";

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<User> findAllByFirstName(String firstName) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", firstName);
        return namedParameterJdbcTemplate.query(SQL_SELECT_BY_FIRST_NAME, params, userRowMapper());
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        Map<String, String> params = new HashMap<>();
        params.put("login", login);
        List<User> users = namedParameterJdbcTemplate.query(SQL_SELECT_BY_LOGIN, params, userRowMapper());

        if (users.isEmpty()) {
            return Optional.empty();
        }

        return Optional.of(users.get(0));
    }

    @Override
    public List<User> findAllByRoleName(String role) {
        Map<String, String> params = new HashMap<>();
        params.put("role", role);
        return namedParameterJdbcTemplate.query(SQL_SELECT_BY_ROLE, params, userRowMapper());
    }

    public Optional<User> findById(Long id) {
        Map<String,Long> params = new HashMap<>();
        return findById(SQL_SELECT_BY_ID,params,userRowMapper());
    }

    @Override
    public boolean delete(Long id) {
        Map<String, Long> params = new HashMap<>();
        params.put("id", id);
        if (findById(id).isPresent()) {
            try {
                namedParameterJdbcTemplate.update(SQL_DELETE_BY_ID, params);
                return true;
            } catch (DataAccessException ex) {
                WebConfig.LOGGER.error(ex.getStackTrace());
            }
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        return namedParameterJdbcTemplate.query(SQL_SELECT_ALL, userRowMapper());
    }

    @Override
    public boolean save(User model) {
        Map<String, Object> params = new HashMap<>();
        params.put("firstName", model.getFirstName());
        params.put("lastName", model.getLastName());
        params.put("role",model.getRole());
        params.put("login", model.getLogin());
        params.put("password", model.getPassword());
        params.put("groupId",model.getGroupId());
        return save(SQL_INSERT_USER,params);
    }

    @Override
    public boolean update(User model) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", model.getId());
        params.put("firstName", model.getFirstName());
        params.put("lastName", model.getLastName());
        params.put("login", model.getLogin());
        params.put("password", model.getPassword());
        params.put("groupId", model.getGroupId());
        return update(SQL_UPDATE_BY_ID,params);
    }

    private RowMapper<User> userRowMapper() {
        return (resultSet, i) -> {
            User user = new User(
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getString("role"),
                    resultSet.getString("login"),
                    resultSet.getString("password"),
                    resultSet.getLong("group_id")
            );
            return user;
        };
    }
}
