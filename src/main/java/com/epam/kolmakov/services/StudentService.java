package com.epam.kolmakov.services;

import com.epam.kolmakov.config.WebConfig;
import com.epam.kolmakov.db.models.Group;
import com.epam.kolmakov.db.models.Student;
import com.epam.kolmakov.templates.GroupJdbcTemplate;
import com.epam.kolmakov.templates.StudentJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentJdbcTemplate studentJdbcTemplateImpl;

    @Autowired
    private GroupJdbcTemplate groupJdbcTemplateImpl;

    public void saveStudent(Student student) {
        String groupName = student.getGroupName();
        Optional<Group> group = groupJdbcTemplateImpl.findGroupByName(groupName);
        if (group.isPresent()) {
            Group group1 = group.get();
            student.setGroup(group1);
        }

        studentJdbcTemplateImpl.save(student);
    }

    public List<Student> getStudents(){
        return studentJdbcTemplateImpl.findAll();
    }
}
