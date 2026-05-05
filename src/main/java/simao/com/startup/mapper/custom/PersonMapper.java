package simao.com.startup.mapper.custom;

import simao.com.startup.dto.v2.PersonDtoV2;
import simao.com.startup.model.Person;

import java.util.Date;

public class PersonMapper {

    public static PersonDtoV2 convertEntityToDto(Person person) {
        return new PersonDtoV2(
                person.getId(),
                person.getGender(),
                person.getLastName(),
                person.getFirstName(),
                person.getAddress(),
                new Date()
        );
    }

    public static Person convertDtoToEntity(PersonDtoV2 personDtoV2) {
        return new Person(
            personDtoV2.getId(),
            personDtoV2.getGender(),
            personDtoV2.getLastName(),
            personDtoV2.getFirstName(),
            personDtoV2.getAddress()
        );
    }
}
