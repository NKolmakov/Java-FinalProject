package com.epam.kolmakov.security;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private AuthenticationService authenticationService;
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder manager){
//        try {
//            manager.userDetailsService(authenticationService);
//        } catch (Exception e) {
//            WebConfig.LOGGER.error(e.getStackTrace());
//        }
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
//        http.authorizeRequests().antMatchers("/","/login","/registration").permitAll();
//        http.authorizeRequests().antMatchers("/mainStudent").access("hasRole('ROLE_STUDENT')");
//        http.authorizeRequests().antMatchers("/mainTutor").access("hasRole('ROLE_TUTOR')");
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/resources/jsp/403.jsp");
//        http.authorizeRequests().and().formLogin()
//                .loginProcessingUrl("/signIn")
//                .loginPage("/resources/jsp/authorization/authorization.jsp")
//                .failureUrl("/resources/jsp/authorization/authorizationError.jsp")
//                .usernameParameter("login")
//                .passwordParameter("password");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(authenticationService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//}
