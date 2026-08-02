package simao.com.startup.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import simao.com.startup.dto.v1.PersonDto;
import simao.com.startup.dto.v2.PersonDtoV2;
import simao.com.startup.services.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<PersonDto> findAll() {
        return personService.findAll();
    }

    @GetMapping(value = "/{id}")
    public PersonDto findById(@PathVariable Long id) {
        return personService.findById(id);
    }

    @PostMapping
    public PersonDto create(@RequestBody PersonDto personDto) {
        return personService.create(personDto);
    }

    @PostMapping(value = "/v2")
    public PersonDtoV2 create(@RequestBody PersonDtoV2 personDtoV2) {
        return personService.createV2(personDtoV2);
    }

    @PutMapping
        public PersonDto update(@RequestBody PersonDto personDto) {
        return personService.update(personDto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
