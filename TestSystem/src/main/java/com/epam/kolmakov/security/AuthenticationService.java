package com.epam.kolmakov.security;

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
