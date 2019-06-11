package com.epam.kolmakov.db.dao.user;

import com.epam.kolmakov.db.dao.CrudDao;
import com.epam.kolmakov.db.models.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends CrudDao<User> {
    List<User> findAllByFirstName(String firstName);
    Optional<User> findUserByLogin(String login);
    List<User> findAllByRoleName(String role);
}
