package com.example.springweb.controller;

import com.example.springweb.PersonsCRUD;
import com.example.springweb.model.Greeting;
import com.example.springweb.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/")
public class PersonController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private PersonsCRUD personsCRUD;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Person>> showPerson() {
       return ResponseEntity.ok().body(personsCRUD.getAll());
    }

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public ResponseEntity<Person> showPerson() {
//       return ResponseEntity.ok().body(personsCRUD.getById(1));
//    }

    @RequestMapping(value = "/value", method = RequestMethod.GET)
    public ResponseEntity<Greeting> greetingPost(@RequestParam(value="name", defaultValue="World") String name) {
       return ResponseEntity.ok().body(new Greeting(counter.incrementAndGet(),
                String.format(template, "Somebody")));
    }
}