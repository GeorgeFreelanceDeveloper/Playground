package org.example.boot.repository;

import org.example.boot.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class PersonDaoFake implements PersonDao {

    private final static List<Person> DB = new ArrayList<>();

    @Override
    public UUID addPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName(), person.getAge()));
        return id;
    }

    @Override
    public List<Person> getAll() {
        return DB;
    }

    @Override
    public Optional<Person> getBy(UUID id) {
        return DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteBy(UUID id) {
        return DB.removeIf(person -> person.getId().equals(id)) ? 1 : 0;
    }

    @Override
    public int update(Person personUpdate) {
        UUID id = personUpdate.getId();
        return getBy(id)
                .map(person -> {
                    int indexOfPersonToDelete = DB.indexOf(person);
                    if (indexOfPersonToDelete >= 0) {
                        DB.set(indexOfPersonToDelete, new Person(id, personUpdate.getName(), personUpdate.getAge()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
