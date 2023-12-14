package org.example.boot.repository;

import org.example.boot.model.Person;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

public interface PersonDao {

    UUID addPerson(UUID id, Person person);

    default UUID addPerson(Person person){
        UUID id = UUID.randomUUID();
        return addPerson(id, person);
    }

    List<Person> getAll();

    Optional<Person> getBy(UUID id);

    int deleteBy(UUID id);

    int update(Person person);
}
