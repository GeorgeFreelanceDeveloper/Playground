package org.example.boot.repository;

import org.example.boot.model.Person;
import org.example.boot.repository.mapper.PersonRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository("personDaoH2Base")
public class PersonDaoH2Base implements PersonDao {


    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private PersonRowMapper personRowMapper;

    private static final String GET_ALL_SQL = "select id, name, age from person";
    private static final String GET_BY_SQL = "select id, name, age from person where id = :id";

    private static final String ADD_SQL = "INSERT INTO person (id, name, age) VALUES (:id, :name, :age)";

    private static final String DELETE_BY_SQL = "DELETE FROM person WHERE id = :id";

    private static final String UPDATE_SQL = "UPDATE person SET name=:name, age=:age WHERE id=:id";

    @Autowired
    public PersonDaoH2Base(NamedParameterJdbcTemplate namedParameterJdbcTemplate, PersonRowMapper personRowMapper) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.personRowMapper = personRowMapper;
    }

    @Override
    public UUID addPerson(UUID id, Person person) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValue("id", id)
                .addValue("name", person.getName())
                .addValue("age", person.getAge());

        namedParameterJdbcTemplate.update(ADD_SQL, namedParameters);
        return id;
    }

    @Override
    public List<Person> getAll() {
        return namedParameterJdbcTemplate.query(GET_ALL_SQL, personRowMapper);
    }

    @Override
    public Optional<Person> getBy(UUID id) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        List<Person> result = namedParameterJdbcTemplate.query(GET_BY_SQL, namedParameters, personRowMapper);
        return result.isEmpty() ? Optional.empty() : Optional.ofNullable(result.get(0));
    }

    @Override
    public int deleteBy(UUID id) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("id", id);
        return namedParameterJdbcTemplate.update(DELETE_BY_SQL, namedParameters);
    }

    @Override
    public int update(Person person) {
        final SqlParameterSource namedParameters = new MapSqlParameterSource()
                .addValues(Map.ofEntries(
                        Map.entry("id", person.getId()),
                        Map.entry("name", person.getName()),
                        Map.entry("age", person.getAge())
                ));
        return namedParameterJdbcTemplate.update(UPDATE_SQL, namedParameters);
    }
}
