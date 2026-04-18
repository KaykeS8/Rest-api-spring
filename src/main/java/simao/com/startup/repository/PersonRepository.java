package simao.com.startup.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import simao.com.startup.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
