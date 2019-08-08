package com.epam.kolmakov.forms;

import lombok.Data;

@Data
public class UserForm {
    private String firstName;
    private String lastName;
    private String role;
    private Long groupId;
    private String login;
    private String password;
}
