package com.epam.kolmakov.db.dao;

import com.epam.kolmakov.db.models.Student;

import java.util.List;

public interface StudentDao extends CrudDao<Student> {
    List<Student> findAllByFirstName(String firstName);
}
