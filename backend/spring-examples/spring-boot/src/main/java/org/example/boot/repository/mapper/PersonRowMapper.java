package org.example.boot.repository.mapper;

import org.example.boot.model.Person;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

@Component
public class PersonRowMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
        String id = rs.getString("id");
        String name = rs.getString("name");
        Integer age = rs.getInt("age");
        return new Person(UUID.fromString(id), name, age);
    }
}
