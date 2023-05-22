package franxx.code.test.service;

import franxx.code.test.data.Person;
import franxx.code.test.repository.PersonRepository;

public class PersonService {
    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Person get(String id) {
        Person person = repository.selectById(id);
        if (person != null) {
            return person;
        } else {
            throw new IllegalArgumentException("Person not Found!!");
        }
    }
}
