package org.example.boot.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.example.boot.model.Person;
import org.example.boot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;


    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public String index(){
        return "Hello from PersonController";
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Person getPerson(@NotNull @PathVariable("id") UUID id) {
        return personService.getPersonById(id)
                .orElse(null);
    }

    @PostMapping
    public UUID createNewPerson(@NotNull @Valid @RequestBody Person person) {
        return personService.addNewPerson(person);
    }

    @DeleteMapping(path = "{id}")
    public void deletePerson(@NotNull @PathVariable("id") UUID id) {
        personService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@NotNull @Valid @RequestBody Person person) {
        personService.updatePerson(person);
    }
}
