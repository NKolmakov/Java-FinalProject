package com.epam.kolmakov.services;

import com.epam.kolmakov.db.dao.group.GroupDao;
import com.epam.kolmakov.db.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {

    @Autowired
    private GroupDao groupDaoImpl;

    public List<Group> getAllGroups(){
        return groupDaoImpl.findAll();
    }
}
