package com.epam.kolmakov.services;

import com.epam.kolmakov.db.dao.group.GroupDao;
import com.epam.kolmakov.db.dao.user.UserDao;
import com.epam.kolmakov.db.models.Group;
import com.epam.kolmakov.db.models.Roles;
import com.epam.kolmakov.db.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDaoImpl;

    @Autowired
    private GroupDao groupDaoImpl;

    public boolean saveUser(User user) {
        String groupName = user.getGroupName();
        Optional<Group> group = groupDaoImpl.findGroupByName(groupName);

        if (group.isPresent()) {
            Group group1 = group.get();
            user.setGroup(group1);
        }

        if(!userExists(user)) {
            user.setRole(Roles.STUDENT.toString());
            userDaoImpl.save(user);
            return true;
        }

        return false;
    }

    public List<User> getUsers() {
        return userDaoImpl.findAll();
    }

    public Optional<User> getUserByLogin(User user){
        return userDaoImpl.findUserByLogin(user.getLogin());
    }

    public Optional<User> getUserById(Long id){
        return userDaoImpl.findById(id);
    }

    private boolean userExists(User user) {
        if(userDaoImpl.findUserByLogin(user.getLogin()).isPresent()){
            return true;
        }

        return false;
    }

    public boolean isAuthorizationCorrect(User user) {
        Optional<User> userOptional = userDaoImpl.findUserByLogin(user.getLogin());
        if(userOptional.isPresent()){
            User userFromDb = userOptional.get();
            if(userFromDb.getPassword().equals(user.getPassword())){
                return true;
            }
        }
        return false;
    }
}
