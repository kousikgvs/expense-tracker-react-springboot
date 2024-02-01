package com.example.expenseTracker.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.expenseTracker.entity.Person;
import com.example.expenseTracker.repo.PersonRepo;

import java.util.List;

@RestController
public class PersonController {

    private final PersonRepo personRepo;

    // Inject PersonRepo through constructor
    public PersonController(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    // @RequestBody makes it necessary to pass data; it doesn't allow empty data
    @PostMapping("/api/persons")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        return new ResponseEntity<>(personRepo.save(person), HttpStatus.CREATED);
    }

    @GetMapping("/api/persons")
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> persons = personRepo.findAll();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    // Get person by ID using path parameter
    @GetMapping("/api/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable long id) {
        Person person = personRepo.findById(id).orElse(null);

        if (person != null) {
            return new ResponseEntity<>(person, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update person by ID
    @PutMapping("/api/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable long id, @RequestBody Person updatedPerson) {
        // Find the existing person by ID
        Person existingPerson = personRepo.findById(id).orElse(null);

        if (existingPerson != null) {
            // Update the fields of the existing person with the new data
            existingPerson.setName(updatedPerson.getName());
            existingPerson.setEmailAddress(updatedPerson.getEmailAddress());
            existingPerson.setMobileNumber(updatedPerson.getMobileNumber());

            // Save the updated person
            Person savedPerson = personRepo.save(existingPerson);

            return new ResponseEntity<>(savedPerson, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete person by ID
    @DeleteMapping("/api/persons/{id}")
    public ResponseEntity<Person> deletePerson(@PathVariable long id) {
        // Find the existing person by ID
        Person existingPerson = personRepo.findById(id).orElse(null);

        if (existingPerson != null) {
            // Store the existing person data
            Person deletedPerson = new Person(existingPerson);

            // Delete the person by ID
            personRepo.deleteById(id);

            // Return the deleted person data in the response
            return new ResponseEntity<>(deletedPerson, HttpStatus.ACCEPTED);
        } else {
            // Person not found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
