package org.example.boot.service;

import org.example.boot.model.Person;
import org.example.boot.repository.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("personDaoH2Base") PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> getAllPeople() {
        return personDao.getAll();
    }

    public UUID addNewPerson(Person person) {
        return personDao.addPerson(person);
    }

    public Optional<Person> getPersonById(UUID personId) {
        return personDao.getBy(personId);
    }

    public void deletePerson(UUID personId) {
        personDao.deleteBy(personId);
    }

    public void updatePerson(Person person) {
        personDao.update(person);
    }
}
