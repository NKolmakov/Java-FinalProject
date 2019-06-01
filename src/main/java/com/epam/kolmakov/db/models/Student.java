package com.epam.kolmakov.db.models;

import com.epam.kolmakov.forms.StudentForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private String groupName;
    private Group group;

    public Student(String firstName, String lastName, Group group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
    }

    public Student(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Student from(StudentForm studentForm) {
        return Student.builder()
                .firstName(studentForm.getFirstName())
                .lastName(studentForm.getLastName())
                .groupName(studentForm.getGroupName())
                .build();

    }
}
