package com.epam.kolmakov.db.models;

import com.epam.kolmakov.forms.GroupForm;
import lombok.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private Long id;
    private String groupName;
    private List<User> users;

    public Group(Long id, String groupName) {
        this.id = id;
        this.groupName = groupName;
    }

    public static Group from(GroupForm groupForm){
        return Group.builder()
                .groupName(groupForm.getGroupName())
                .users(groupForm.getUsers())
                .build();
    }
}
