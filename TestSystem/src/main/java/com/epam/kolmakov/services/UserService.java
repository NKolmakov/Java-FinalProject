package com.epam.kolmakov.services;

import com.epam.kolmakov.db.dao.group.GroupDao;
import com.epam.kolmakov.db.dao.user.UserDao;
import com.epam.kolmakov.db.models.Group;
import com.epam.kolmakov.db.models.Roles;
import com.epam.kolmakov.db.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserDao userDaoImpl;

    @Autowired
    private GroupDao groupDaoImpl;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public boolean saveUser(User user) {
        Long groupId = user.getGroupId();
        Optional<Group> group = groupDaoImpl.findById(groupId);

        if (group.isPresent()) {
            Group group1 = group.get();
            user.setGroup(group1);
        }

        if(!userExists(user)) {
            user.setRole(Roles.STUDENT.toString());
            String encodedPassword = encoder.encode(user.getPassword());
            user.setPassword(encodedPassword);
            if(userDaoImpl.save(user)) {
                return true;
            }
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

    public Optional<User> checkAuthorization(User user) {
        Optional<User> userOptional = userDaoImpl.findUserByLogin(user.getLogin());
        String encodedPassword = encoder.encode(user.getPassword());
        if(userOptional.isPresent()){
            User userFromDb = userOptional.get();
            if(encoder.matches(user.getPassword(),userFromDb.getPassword())){
                userFromDb.setAuthorized(true);
                return Optional.of(userFromDb);
            }
        }
        return Optional.empty();
    }
}
