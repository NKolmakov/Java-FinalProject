package com.epam.kolmakov.security;

import com.epam.kolmakov.db.dao.user.UserDao;
import com.epam.kolmakov.db.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

//@Service
//public class AuthenticationService implements UserDetailsService {
//
//    @Autowired
//    private UserDao userDaoImpl;
//
//    @Override
//    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
//        Optional<User> optionalUser = userDaoImpl.findUserByLogin(login);
//
//        if(!optionalUser.isPresent()){
//            throw new UsernameNotFoundException("User "+login+"was not found in database");
//        }
//        User user = optionalUser.get();
//        String role = user.getRole();
//        List<GrantedAuthority> grantedAuthorities = new LinkedList<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_"+role.toUpperCase()));
//        System.out.println("User: "+user.getLogin()+" auth: "+grantedAuthorities.get(0).getAuthority().toUpperCase());
//
//        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),grantedAuthorities);
//    }
//}
