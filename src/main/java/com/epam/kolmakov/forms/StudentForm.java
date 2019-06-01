package com.epam.kolmakov.forms;

import com.epam.kolmakov.db.models.Group;
import lombok.Data;

@Data
public class StudentForm {
    private String firstName;
    private String lastName;
    private String groupName;
}
