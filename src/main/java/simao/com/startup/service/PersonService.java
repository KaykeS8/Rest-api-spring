package simao.com.startup.service;

import org.springframework.stereotype.Service;
import simao.com.startup.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(Long id) {
        logger.info("Finding one Person");
        Person person = new Person();
        person.setId(1L);
        person.setFirstName("kayke");
        person.setLastName("simao");
        person.setGender("Masculino");
        person.setAddress("Contagem - MG");
        return person;
    }

    public List<Person> findAll() {
        logger.info("Find all people");
        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person create(Person person) {
        logger.info("Create people");
        return person;
    }

    public Person update(Person person) {
        logger.info("Update person");
        return person;
    }

    public void delete(Long id) {
        logger.info("delete person");
    }

    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("First name: " + i);
        person.setLastName("Last name: " + i);
        person.setGender("Masculino");
        person.setAddress("Contagem - MG");
        return person;
    }

}