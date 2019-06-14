package com.epam.kolmakov.db.models;

import com.epam.kolmakov.forms.UserForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String role;
    private String login;
    private String password;
    private Long groupId;
    private String groupName;
    private boolean isAuthorized;
    private Group group;

    public User(Long id, String firstName, String lastName,String role, String login, String password, Long groupId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
        this.login = login;
        this.password = password;
        this.groupId = groupId;
    }

    public static User from(UserForm userForm) {
        return User.builder()
                .firstName(userForm.getFirstName())
                .lastName(userForm.getLastName())
                .role(userForm.getRole())
                .login(userForm.getLogin())
                .password(userForm.getPassword())
                .groupName(userForm.getGroupName())
                .build();

    }
}
