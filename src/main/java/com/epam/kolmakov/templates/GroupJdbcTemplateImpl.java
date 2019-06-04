package com.epam.kolmakov.templates;

import com.epam.kolmakov.db.dao.GroupDao;
import com.epam.kolmakov.db.models.Group;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GroupJdbcTemplateImpl implements GroupJdbcTemplate {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    //language=SQL
    private static final String SQL_FIND_BY_NAME = "SELECT * FROM `group`WHERE UPPER(group_name) LIKE (UPPER(:groupName))";

    //language=SQL
    private static final String SQL_SELECT_ALL = "SELECT * FROM `group`";
    @Override
    public Optional<Group> find(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Group model) {

    }

    @Override
    public void update(Group model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Group> findAll() {
       return namedParameterJdbcTemplate.query(SQL_SELECT_ALL,groupRowMapper());
    }

    @Override
    public Optional<Group> findGroupByName(String name) {
        Map<String,Object> params = new HashMap<>();
        params.put("groupName",name);
        List<Group> groups = namedParameterJdbcTemplate.query(SQL_FIND_BY_NAME,params,groupRowMapper());

        if(groups.isEmpty()){
            return Optional.empty();
        }
        return Optional.of(groups.get(0));
    }

    private RowMapper<Group> groupRowMapper(){
        return (resultSet, i) -> {
          Group group = new Group(
                  resultSet.getLong("group_id"),
                  resultSet.getString("group_name")
          );
          return group;
        };
    }
}
