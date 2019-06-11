package com.epam.kolmakov.db.dao.group;

import com.epam.kolmakov.db.dao.CrudDao;
import com.epam.kolmakov.db.models.Group;

import java.util.Optional;

public interface GroupDao extends CrudDao<Group> {
    Optional<Group> findGroupByName(String name);
}
