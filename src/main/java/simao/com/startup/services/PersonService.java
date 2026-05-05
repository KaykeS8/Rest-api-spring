package simao.com.startup.services;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import simao.com.startup.dto.v1.PersonDto;
import simao.com.startup.dto.v2.PersonDtoV2;
import simao.com.startup.exception.ResourceNotFoundException;
import static simao.com.startup.mapper.ObjectMapper.*;

import simao.com.startup.mapper.custom.PersonMapper;
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

    public List<PersonDto> findAll() {
        logger.debug("DEBUG");
        return parseListObject(personRepository.findAll(), PersonDto.class);
    }

    public PersonDto findById(Long id) {
        logger.info("Finding one person");
        return personRepository.findById(id)
                .map(person -> parseObject(person, PersonDto.class))
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
    }

    public PersonDto create(PersonDto personDto) {
        logger.info("Creating person");
        Person person = parseObject(personDto, Person.class);
        return parseObject(personRepository.save(person), PersonDto.class);
    }

    public PersonDtoV2 createV2(PersonDtoV2 personDtoV2) {
        logger.info("Creating person (V2)");
        Person person = PersonMapper.convertDtoToEntity(personDtoV2);
        return PersonMapper.convertEntityToDto(personRepository.save(person));
    }

    public PersonDto update(PersonDto personDto) {
        logger.info("Update person");
        return personRepository.findById(personDto.getId())
                .map((person1) -> {
                    person1.setFirstName(personDto.getFirstName());
                    person1.setLastName(personDto.getLastName());
                    person1.setGender(personDto.getGender());
                    person1.setAddress(personDto.getAddress());
                    return parseObject(personRepository.save(person1), PersonDto.class);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
    }

    public void delete(Long id) {
        logger.info("delete person");
        if(!personRepository.existsById(id)) throw new ResourceNotFoundException("Person not found");
        personRepository.deleteById(id);
    }

}