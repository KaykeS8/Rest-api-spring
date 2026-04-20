package simao.com.startup.services;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import simao.com.startup.exception.ResourceNotFoundException;
import simao.com.startup.model.Person;
import simao.com.startup.repository.PersonRepository;

import java.util.List;
import org.slf4j.Logger;

@Service
public class PersonService {

    private static final Logger logger = LoggerFactory.getLogger(PersonService.class);
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll() {
        logger.debug("DEBUG");
        return personRepository.findAll();
    }

    public Person findById(Long id) {
        logger.info("Finding one person");
        return personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
    }

    public Person create(Person person) {
        logger.info("Creating person");
        return personRepository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update person");
        return personRepository.findById(person.getId())
                .map((person1) -> {
                    person1.setFirstName(person.getFirstName());
                    person1.setLastName(person.getLastName());
                    person1.setGender(person.getGender());
                    person1.setAddress(person.getAddress());
                    return personRepository.save(person1);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
    }

    public void delete(Long id) {
        logger.info("delete person");
        if(!personRepository.existsById(id)) throw new ResourceNotFoundException("Person not found");
        personRepository.deleteById(id);
    }

}