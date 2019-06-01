package com.epam.kolmakov.forms;

import com.epam.kolmakov.db.models.Student;
import lombok.Data;

import java.util.List;

@Data
public class GroupForm {
    private Long id;
    private String groupName;
    private List<Student> students;
}
